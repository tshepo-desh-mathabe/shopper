package dubby.serve.xfood.util.validator;

import dubby.serve.xfood.domain.account.dto.EmailAddressDto;

/**
 * Operations needed to be validated
 */
public interface IValidator {

    /**
     * Validates if mail is in proper format
     * @param email - incoming string value to be validated
     * @return - returns true if mail is in proper format, otherwise false
     */
    boolean isValidEmailAddress(EmailAddressDto email);

    boolean isBadIpAddress(String ipAddress);

}
