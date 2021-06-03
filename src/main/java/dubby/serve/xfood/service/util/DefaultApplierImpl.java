package dubby.serve.xfood.service.util;

import dubby.serve.xfood.domain.account.UserAccountProfileStatus;
import dubby.serve.xfood.domain.account.UserRole;
import dubby.serve.xfood.domain.account.dto.*;
import dubby.serve.xfood.repository.account.IUserAccountProfileStatusRepository;
import dubby.serve.xfood.repository.account.IUserRoleRepository;
import dubby.serve.xfood.util.constants.AccountStatus;
import dubby.serve.xfood.util.constants.AppConstant;
import dubby.serve.xfood.util.constants.RoleType;
import dubby.serve.xfood.util.helper.IDefaultApplier;
import dubby.serve.xfood.util.helper.IModelMapper;
import dubby.serve.xfood.util.property_fetcher.IPropertyFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DefaultApplierImpl implements IDefaultApplier {

    @Autowired
    private IUserRoleRepository roleRepository;
    @Autowired
    private IUserAccountProfileStatusRepository accountProfileStatusRepository;
    @Autowired
    private IModelMapper<UserRole, UserRoleDto> roleMapper;
    @Autowired
    private IModelMapper<UserAccountProfileStatus, UserAccountProfileStatusDto> accountProfileMapper;
    @Autowired
    private IPropertyFetcher propertyFetcher;

    @Override
    public void applyDefaults(UserDto userRequest) {
        setSecureAccountDefault(userRequest);
        setRole(userRequest);
    }

    private void setRole(UserDto userRequest) {
        boolean isAdminUser = userRequest.getUserRoleDetails().stream()
                .map(e -> e.getType().contains(RoleType.ROLE_ADMIN.name())).collect(Collectors.toList()).get(0);

        List<UserRole> roles = null;

        if (isAdminUser) {
            roles = assignRole(RoleType.ROLE_SYS_USER);
        } else {
            roles = assignRole(RoleType.ROLE_USER);
        }
        userRequest.setUserRoleDetails(roleMapper.toDto(roles));
    }

    private List<UserRole> assignRole(RoleType roleType) {
        return Collections.singletonList(roleRepository.findByRoleType(roleType));
    }

    private void setSecureAccountDefault(UserDto userDto) {
        SecureAccountDto account = new SecureAccountDto();
        account.setAccountEnabledDetails(new AccountEnabledDto(true));
        account.setAccountNonExpiredDetails(new AccountNonExpiredDto(true));
        account.setCredentialsNonExpiredDetails(new CredentialsNonExpiredDto(true));
        account.setAccountNonLockedDetails(new AccountNonLockedDto(true));
        setProfileStatusDefault(account);
        userDto.setSecureAccountDetails(account);
    }

    private void setProfileStatusDefault(SecureAccountDto account) {
        UserAccountProfileStatusDto profileStatus = accountProfileMapper.toDto(
                accountProfileStatusRepository.getByAccountStatus(AccountStatus.INITIAL)
        );
        String reason = propertyFetcher.getProperty(AppConstant.VERIFICATION_REASON_MESSAGE);
        account.setUserAccountStatusDetails(new UserAccountStatusDto(reason, profileStatus));
    }

}
