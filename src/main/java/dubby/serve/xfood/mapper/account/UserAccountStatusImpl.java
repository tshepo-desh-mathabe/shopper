package dubby.serve.xfood.mapper.account;

import dubby.serve.xfood.domain.account.UserAccountStatus;
import dubby.serve.xfood.domain.account.dto.UserAccountStatusDto;
import dubby.serve.xfood.util.helper.IFieldPropertyMapper;
import dubby.serve.xfood.util.helper.IModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserAccountStatusImpl implements IModelMapper<UserAccountStatus, UserAccountStatusDto> {

    @Override
    public UserAccountStatus toEntity(UserAccountStatusDto accountStatusDto) {
        return convertToEntity(accountStatusDto);
    }

    @Override
    public UserAccountStatusDto toDto(UserAccountStatus accountStatus) {
        return convertToDto(accountStatus);
    }

    private UserAccountStatusDto convertToDto(UserAccountStatus userAccountStatus) {
        if (userAccountStatus != null) {
            IFieldPropertyMapper<UserAccountStatusDto> mapper = destination -> {
                destination.setUserAccountStatusId(userAccountStatus.getId());
                destination.setUserAccountStatusReason(userAccountStatus.getReason());
                destination.setUserAccountProfileStatusDetails(
                        new UserAccountProfileStatusImpl().toDto(userAccountStatus.getUserAccountProfileStatus())
                );
                destination.setCreatedAt(userAccountStatus.getCreatedAt());
                destination.setLastUntil(userAccountStatus.getLastUntil());


                return destination;
            };

            return mapper.mapTo(new UserAccountStatusDto());
        } else {
            return null;
        }
    }

    private UserAccountStatus convertToEntity(UserAccountStatusDto accountStatusDto) {
        if (accountStatusDto != null) {
            IFieldPropertyMapper<UserAccountStatus> mapper = destination -> {
                destination.setId(accountStatusDto.getUserAccountStatusId());
                destination.setReason(accountStatusDto.getUserAccountStatusReason());
                destination.setUserAccountProfileStatus(
                        new UserAccountProfileStatusImpl().toEntity(accountStatusDto.getUserAccountProfileStatusDetails())
                );
                destination.setCreatedAt(accountStatusDto.getCreatedAt());
                destination.setLastUntil(accountStatusDto.getLastUntil());

                return destination;
            };

            return mapper.mapTo(new UserAccountStatus());
        } else {
            return null;
        }
    }

}
