package dubby.serve.xfood.mapper.account;

import dubby.serve.xfood.domain.account.CredentialsNonExpired;
import dubby.serve.xfood.domain.account.dto.CredentialsNonExpiredDto;
import dubby.serve.xfood.util.helper.IFieldPropertyMapper;
import dubby.serve.xfood.util.helper.IModelMapper;

public class CredentialsNonExpiredMapperImpl implements IModelMapper<CredentialsNonExpired, CredentialsNonExpiredDto> {

    @Override
    public CredentialsNonExpired toEntity(CredentialsNonExpiredDto dto) {
        return convertToEntity(dto);
    }

    @Override
    public CredentialsNonExpiredDto toDto(CredentialsNonExpired entity) {
        return convertToDto(entity);
    }

    private CredentialsNonExpiredDto convertToDto(CredentialsNonExpired credentialsNonExpired) {
        if (credentialsNonExpired != null) {
            IFieldPropertyMapper<CredentialsNonExpiredDto> mapper = destination -> {
                destination.setCredentialsNonExpiredId(credentialsNonExpired.getId());
                destination.setExpired(credentialsNonExpired.getCredentialsExpired());
                destination.setCreatedAtDate(credentialsNonExpired.getCreatedAt());
                destination.setLastUntilDate(credentialsNonExpired.getLastUntil());

                return destination;
            };

            return mapper.mapTo(new CredentialsNonExpiredDto());
        } else {
            return null;
        }
    }

    private CredentialsNonExpired convertToEntity(CredentialsNonExpiredDto credentialsNonExpiredDto) {
        if (credentialsNonExpiredDto != null) {
            IFieldPropertyMapper<CredentialsNonExpired> mapper = destination -> {
                destination.setId(credentialsNonExpiredDto.getCredentialsNonExpiredId());
                destination.setCredentialsExpired(credentialsNonExpiredDto.getExpired());
                destination.setCreatedAt(credentialsNonExpiredDto.getCreatedAtDate());
                destination.setLastUntil(credentialsNonExpiredDto.getLastUntilDate());

                return destination;
            };

            return mapper.mapTo(new CredentialsNonExpired());
        } else {
            return null;
        }
    }
}
