package dubby.serve.xfood.mapper.account;

import dubby.serve.xfood.domain.account.AccountEnabled;
import dubby.serve.xfood.domain.account.dto.AccountEnabledDto;
import dubby.serve.xfood.util.helper.IFieldPropertyMapper;
import dubby.serve.xfood.util.helper.IModelMapper;

public class AccountEnabledMapperImpl implements IModelMapper<AccountEnabled, AccountEnabledDto> {

    @Override
    public AccountEnabled toEntity(AccountEnabledDto dto) {
        return convertToEntity(dto);
    }

    @Override
    public AccountEnabledDto toDto(AccountEnabled entity) {
        return convertToDto(entity);
    }

    private AccountEnabledDto convertToDto(AccountEnabled accountEnabled) {
        if (accountEnabled != null) {
            IFieldPropertyMapper<AccountEnabledDto> mapper = destination -> {
                destination.setAccountEnabledId(accountEnabled.getId());
                destination.setEnabled(accountEnabled.getEnabled());
                destination.setCreatedAtDate(accountEnabled.getCreatedAt());
                destination.setLastUntilDate(accountEnabled.getLastUntil());

                return destination;
            };

            return mapper.mapTo(new AccountEnabledDto());
        } else {
            return null;
        }
    }

    private AccountEnabled convertToEntity(AccountEnabledDto accountEnabledDto) {
        if (accountEnabledDto != null) {
            IFieldPropertyMapper<AccountEnabled> mapper = destination -> {
                destination.setId(accountEnabledDto.getAccountEnabledId());
                destination.setEnabled(accountEnabledDto.getEnabled());
                destination.setCreatedAt(accountEnabledDto.getCreatedAtDate());
                destination.setLastUntil(accountEnabledDto.getLastUntilDate());

                return destination;
            };

            return mapper.mapTo(new AccountEnabled());
        } else {
            return null;
        }
    }
}
