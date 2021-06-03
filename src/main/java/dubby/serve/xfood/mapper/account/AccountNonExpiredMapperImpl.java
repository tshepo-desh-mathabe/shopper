package dubby.serve.xfood.mapper.account;

import dubby.serve.xfood.domain.account.AccountNonExpired;
import dubby.serve.xfood.domain.account.dto.AccountNonExpiredDto;
import dubby.serve.xfood.util.helper.IFieldPropertyMapper;
import dubby.serve.xfood.util.helper.IModelMapper;

public class AccountNonExpiredMapperImpl implements IModelMapper<AccountNonExpired, AccountNonExpiredDto> {

    @Override
    public AccountNonExpired toEntity(AccountNonExpiredDto dto) {
        return convertToEntity(dto);
    }

    @Override
    public AccountNonExpiredDto toDto(AccountNonExpired entity) {
        return convertToDto(entity);
    }

    private AccountNonExpiredDto convertToDto(AccountNonExpired accountNonExpired) {
        if (accountNonExpired != null) {
            IFieldPropertyMapper<AccountNonExpiredDto> mapper = destination -> {
                destination.setAccountNonExpiredId(accountNonExpired.getId());
                destination.setExpired(accountNonExpired.getAccountExpired());
                destination.setCreatedAtDate(accountNonExpired.getCreatedAt());
                destination.setLastUntilDate(accountNonExpired.getLastUntil());

                return destination;
            };

            return mapper.mapTo(new AccountNonExpiredDto());
        } else {
            return null;
        }
    }

    private AccountNonExpired convertToEntity(AccountNonExpiredDto accountNonExpiredDto) {
        if (accountNonExpiredDto != null) {
            IFieldPropertyMapper<AccountNonExpired> mapper = destination -> {
                destination.setId(accountNonExpiredDto.getAccountNonExpiredId());
                destination.setAccountExpired(accountNonExpiredDto.getExpired());
                destination.setCreatedAt(accountNonExpiredDto.getCreatedAtDate());
                destination.setLastUntil(accountNonExpiredDto.getLastUntilDate());

                return destination;
            };

            return mapper.mapTo(new AccountNonExpired());
        } else {
            return null;
        }
    }
}
