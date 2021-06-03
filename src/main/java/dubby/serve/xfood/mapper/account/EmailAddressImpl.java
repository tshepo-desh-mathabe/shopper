package dubby.serve.xfood.mapper.account;

import dubby.serve.xfood.domain.account.EmailAddress;
import dubby.serve.xfood.domain.account.dto.EmailAddressDto;
import dubby.serve.xfood.util.helper.IFieldPropertyMapper;
import dubby.serve.xfood.util.helper.IModelMapper;
import org.springframework.stereotype.Component;

/**
 * EmailAddress Entity to DTO mapper implementor and vice-versa
 */
@Component
public class EmailAddressImpl implements IModelMapper<EmailAddress, EmailAddressDto> {

    @Override
    public EmailAddressDto toDto(EmailAddress emailAddress) {
        return convertToDto(emailAddress);
    }

    @Override
    public EmailAddress toEntity(EmailAddressDto emailAddressDto) {
        return convertToEntity(emailAddressDto);
    }

    /**
     * Converts EmailAddress Entity to EmailAddressDTO
     * @param emailAddress - entity object to be converted into a DTO
     * @return - returns a converted Object in DTO format
     */
    private EmailAddressDto convertToDto(EmailAddress emailAddress) {
        if (emailAddress != null) {
            IFieldPropertyMapper<EmailAddressDto> mapper = destination -> {
                destination.setEmailId(emailAddress.getEmailId());
                destination.setEmailAddress(emailAddress.getAddress());

                return destination;
            };

            return mapper.mapTo(new EmailAddressDto());
        } else {
            return null;
        }
    }

    /**
     * Converts EmailAddressDTO to EmailAddress entity
     * @param emailAddressDto - DTO to be converted into an entity
     * @return - returns a converted Object in DTO format
     */
    private EmailAddress convertToEntity(EmailAddressDto emailAddressDto) {
        if (emailAddressDto != null) {
            IFieldPropertyMapper<EmailAddress> mapper = destination -> {
                destination.setEmailId(emailAddressDto.getEmailId());
                destination.setAddress(emailAddressDto.getEmailAddress());

                return destination;
            };

            return mapper.mapTo(new EmailAddress());
        } else {
            return null;
        }
    }
}
