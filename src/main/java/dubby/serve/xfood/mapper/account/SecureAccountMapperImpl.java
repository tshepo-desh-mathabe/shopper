package dubby.serve.xfood.mapper.account;

import dubby.serve.xfood.domain.account.AccountNonExpired;
import dubby.serve.xfood.domain.account.SecureAccount;
import dubby.serve.xfood.domain.account.dto.CredentialsNonExpiredDto;
import dubby.serve.xfood.domain.account.dto.SecureAccountDto;
import dubby.serve.xfood.util.helper.IFieldPropertyMapper;
import dubby.serve.xfood.util.helper.IModelMapper;

public class SecureAccountMapperImpl implements IModelMapper<SecureAccount, SecureAccountDto> {

    @Override
    public SecureAccount toEntity(SecureAccountDto dto) {
        return convertToEntity(dto);
    }

    @Override
    public SecureAccountDto toDto(SecureAccount entity) {
        return convertToDto(entity);
    }

    private SecureAccountDto convertToDto(SecureAccount secureAccount) {
        if (secureAccount != null) {
            IFieldPropertyMapper<SecureAccountDto> mapper = destination -> {
                destination.setSecureAccountId(secureAccount.getId());
                destination.setAccountEnabledDetails(
                        new AccountEnabledMapperImpl().toDto(secureAccount.getAccountEnabled())
                );
                destination.setAccountNonExpiredDetails(
                        new AccountNonExpiredMapperImpl().toDto(secureAccount.getAccountNonExpired())
                );
                destination.setAccountNonLockedDetails(
                        new AccountNonLockedMapperImpl().toDto(secureAccount.getAccountNonLocked())
                );
                destination.setCredentialsNonExpiredDetails(
                        new CredentialsNonExpiredMapperImpl().toDto(secureAccount.getCredentialsNonExpired())
                );
                destination.setUserAccountStatusDetails(
                        new UserAccountStatusImpl().toDto(secureAccount.getUserAccountStatus())
                );

                return destination;
            };

            return mapper.mapTo(new SecureAccountDto());
        } else {
            return null;
        }
    }

    private SecureAccount convertToEntity(SecureAccountDto secureAccountDto) {
        if (secureAccountDto != null) {
            IFieldPropertyMapper<SecureAccount> mapper = destination -> {
                destination.setId(secureAccountDto.getSecureAccountId());
                destination.setAccountEnabled(
                        new AccountEnabledMapperImpl().toEntity(secureAccountDto.getAccountEnabledDetails())
                );
                destination.setAccountNonExpired(
                        new AccountNonExpiredMapperImpl().toEntity(secureAccountDto.getAccountNonExpiredDetails())
                );
                destination.setAccountNonLocked(
                        new AccountNonLockedMapperImpl().toEntity(secureAccountDto.getAccountNonLockedDetails())
                );
                destination.setCredentialsNonExpired(
                        new CredentialsNonExpiredMapperImpl().toEntity(secureAccountDto.getCredentialsNonExpiredDetails())
                );
                destination.setUserAccountStatus(
                        new UserAccountStatusImpl().toEntity(secureAccountDto.getUserAccountStatusDetails())
                );

                return destination;
            };

            return mapper.mapTo(new SecureAccount());
        } else {
            return null;
        }
    }
}
