package dubby.serve.xfood.service.util;

import dubby.serve.xfood.domain.account.User;
import dubby.serve.xfood.domain.account.dto.UserDto;
import dubby.serve.xfood.domain.emailverification.dto.VerifyDto;
import dubby.serve.xfood.repository.account.IEmailAddressRepository;
import dubby.serve.xfood.repository.account.IMobileNumberRepository;
import dubby.serve.xfood.repository.account.IUserRepository;
import dubby.serve.xfood.util.constants.AppConstant;
import dubby.serve.xfood.util.constants.RoleType;
import dubby.serve.xfood.util.helper.IDefaultApplier;
import dubby.serve.xfood.util.helper.IModelMapper;
import dubby.serve.xfood.util.helper.IService;
import dubby.serve.xfood.util.helper.IStoreDoctor;
import dubby.serve.xfood.util.property_fetcher.IPropertyFetcher;
import dubby.serve.xfood.util.response.ApiResponse;
import dubby.serve.xfood.util.response.ResponseApiWrapper;
import dubby.serve.xfood.util.validator.IValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * Service implementation logic
 */
@Component
//@Qualifier("userServiceImpl")
public class UserServiceImpl implements IStoreDoctor<UserDto> {

    @Autowired
    private IValidator validator;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private IPropertyFetcher propertyFetcher;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IEmailAddressRepository emailAddressRepository;
    @Autowired
    private IMobileNumberRepository mobileNumberRepository;
    @Autowired
    private IModelMapper<User, UserDto> userMapper;
    @Autowired
    private IDefaultApplier defaultApplier;
    @Autowired
    private IService<VerifyDto> iService;

    @Override
    public ResponseEntity<?> saveData(UserDto userDto) {
        if(!isPersistentReady(userDto).getSuccess()) {
            return ResponseApiWrapper.badRequest(isPersistentReady(userDto).getMessage());
        } else {
            userDto.setPwd(passwordEncoder.encode(userDto.getPwd()));
            long id = userRepository.save(userMapper.toEntity(userDto)).getId();
            boolean isAdminUser = userDto.getUserRoleDetails()
                    .stream()
                    .map(e -> e.getType().contains(RoleType.ROLE_ADMIN.name())).collect(Collectors.toList()).get(0);

            if (!isAdminUser) { // watch this...
                storeVerificationData(id, userDto);
            }

            return ResponseApiWrapper.okRequest(propertyFetcher.getProperty(AppConstant.USER_REGISTERED_MESSAGE));
        }
    }

    @Override
    public ApiResponse isPersistentReady(UserDto userRequest) {
        if (userRepository.existsByKnownAs(userRequest.getKnownAs())) {
            return new ApiResponse(false, propertyFetcher.getProperty(AppConstant.USERNAME_TAKEN_MESSAGE));
        } else if (!isContactPersistReady(userRequest).getSuccess()) {
            return isContactPersistReady(userRequest);
        } else if(!validator.isBadIpAddress(userRequest.getContactDetails().getDeviceIpAddressDetails().getDeviceIpAddress())) {
            return new ApiResponse(false, propertyFetcher.getProperty(AppConstant.UNRECOGNIZED_IP_MESSAGE));
        } else {
            defaultApplier.applyDefaults(userRequest);
            return new ApiResponse(true);
        }
    }

    private void storeVerificationData(long userId, UserDto data) {
        String fullName = data.getFirstName() + " " + data.getLastName();
        iService.storeData(
            new VerifyDto(userId, data.getContactDetails().getEmailAddressDetails().getEmailAddress(), fullName)
        );
    }

    private ApiResponse isContactPersistReady(UserDto userRequest) {
        if (userRequest.getContactDetails() != null) {
            if (!validator.isValidEmailAddress(userRequest.getContactDetails().getEmailAddressDetails())) {
                return new ApiResponse(false, propertyFetcher.getProperty(AppConstant.BAD_EMAIL_FORMAT_MESSAGE));
            }  else if (emailAddressRepository.existsByAddress(userRequest.getContactDetails().getEmailAddressDetails().getEmailAddress())) {
                return new ApiResponse(false, propertyFetcher.getProperty(AppConstant.EMAIL_IN_USE_MESSAGE));
            } else if (userRequest.getContactDetails().getEmailAddressDetails().getEmailAddress() != null
                    && mobileNumberRepository.existsByNumber(userRequest.getContactDetails().getMobileNumberDetails().getNumber())) {
                return new ApiResponse(false, propertyFetcher.getProperty(AppConstant.MOBILE_NUMBER_IN_USE_MESSAGE));
            } else {
                return new ApiResponse(true);
            }
        } else {
            return new ApiResponse(false, propertyFetcher.getProperty(AppConstant.CONTACT_DETAILS_REQUIRED_MESSAGE));
        }
    }
}
