package dubby.serve.xfood.mapper.account;

import dubby.serve.xfood.domain.account.AccountNonLocked;
import dubby.serve.xfood.domain.account.dto.AccountNonLockedDto;
import dubby.serve.xfood.util.helper.IFieldPropertyMapper;
import dubby.serve.xfood.util.helper.IModelMapper;

public class AccountNonLockedMapperImpl implements IModelMapper<AccountNonLocked, AccountNonLockedDto> {
    
    @Override
    public AccountNonLocked toEntity(AccountNonLockedDto dto) {
        return convertToEntity(dto);
    }

    @Override
    public AccountNonLockedDto toDto(AccountNonLocked entity) {
        return convertToDto(entity);
    }

    private AccountNonLockedDto convertToDto(AccountNonLocked accountNonLocked) {
        if (accountNonLocked != null) {
            IFieldPropertyMapper<AccountNonLockedDto> mapper = destination -> {
                destination.setAccountNonLockedId(accountNonLocked.getId());
                destination.setNotLocked(accountNonLocked.getAccountNonLocked());
                destination.setCreatedAtDate(accountNonLocked.getCreatedAt());
                destination.setLastUntilDate(accountNonLocked.getLastUntil());

                return destination;
            };

            return mapper.mapTo(new AccountNonLockedDto());
        } else {
            return null;
        }
    }

    private AccountNonLocked convertToEntity(AccountNonLockedDto accountNonLockedDto) {
        if (accountNonLockedDto != null) {
            IFieldPropertyMapper<AccountNonLocked> mapper = destination -> {
                destination.setId(accountNonLockedDto.getAccountNonLockedId());
                destination.setAccountNonLocked(accountNonLockedDto.getNotLocked());
                destination.setCreatedAt(accountNonLockedDto.getCreatedAtDate());
                destination.setLastUntil(accountNonLockedDto.getLastUntilDate());

                return destination;
            };

            return mapper.mapTo(new AccountNonLocked());
        } else {
            return null;
        }
    }
}
