package dubby.serve.xfood.mapper.account;

import dubby.serve.xfood.domain.account.User;
import dubby.serve.xfood.domain.account.dto.UserDto;
import dubby.serve.xfood.mapper.globe.UseGloballyImpl;
import dubby.serve.xfood.mapper.store.StoreDetailsImpl;
import dubby.serve.xfood.util.helper.IFieldPropertyMapper;
import dubby.serve.xfood.util.helper.IModelMapper;
import org.springframework.stereotype.Component;

/**
 * User Entity to DTO mapper implementor and vice-versa
 */
@Component
public class UserImpl implements IModelMapper<User, UserDto> {

    @Override
    public UserDto toDto(User user) {
        return convertToDto(user);
    }

    @Override
    public User toEntity(UserDto userDto) {
        return convertToEntity(userDto);
    }

    /**
     * Converts User Entity to UserDTO
     * @param user - entity object to be converted into a DTO
     * @return - returns a converted Object in DTO format
     */
    private UserDto convertToDto(User user) {
        if (user != null) {
            IFieldPropertyMapper<UserDto> mapper = destination -> {
                destination.setUserId(user.getId());
                destination.setKnownAs(user.getKnownAs());
                destination.setFirstName(user.getFirstName());
                destination.setLastName(user.getLastName());
                destination.setPwd(user.getPassword());
                destination.setSecureAccountDetails(new SecureAccountMapperImpl().toDto(user.getSecureAccount()));
                destination.setUserRoleDetails(new UserRoleImpl().toDto(user.getRoles()));
                destination.setContactDetails(new ContactDetailsImpl().toDto(user.getContactDetails()));
                destination.setUserStoreDetails(new StoreDetailsImpl().toDto(user.getStoreDetails()));
                destination.setUseUserGlobally(new UseGloballyImpl().toDto(user.getUseGlobally()));
                destination.setCreatedAtDate(user.getCreatedAt());
                destination.setUpdatedAtDate(user.getUpdatedAt());

                return destination;
            };

            return mapper.mapTo(new UserDto());
        } else {
            return null;
        }
    }

    /**
     * Converts UserDTO to User entity
     * @param userDto - DTO to be converted into an entity
     * @return - returns a converted Object in DTO format
     */
    private User convertToEntity(UserDto userDto) {
        if (userDto != null) {
            IFieldPropertyMapper<User> mapper = destination -> {
                destination.setId(userDto.getUserId());
                destination.setKnownAs(userDto.getKnownAs());
                destination.setFirstName(userDto.getFirstName());
                destination.setLastName(userDto.getLastName());
                destination.setPassword(userDto.getPwd());
                destination.setSecureAccount(new SecureAccountMapperImpl().toEntity(userDto.getSecureAccountDetails()));
                destination.setRoles(new UserRoleImpl().toEntity(userDto.getUserRoleDetails()));
                destination.setContactDetails(new ContactDetailsImpl().toEntity(userDto.getContactDetails()));
                destination.setStoreDetails(new StoreDetailsImpl().toEntity(userDto.getUserStoreDetails()));
                destination.setUseGlobally(new UseGloballyImpl().toEntity(userDto.getUseUserGlobally()));
                destination.setCreatedAt(userDto.getCreatedAtDate());
                destination.setUpdatedAt(userDto.getUpdatedAtDate());

                return destination;
            };

            return mapper.mapTo(new User());
        } else {
            return null;
        }
    }
}
