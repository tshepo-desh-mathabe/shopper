package dubby.serve.xfood.domain.account.dto;

/**
 * A Email Address DTO
 */
public class EmailAddressDto {

    private Long emailId;
    private String emailAddress;

    public long getEmailId() {
        return emailId;
    }

    public void setEmailId(long emailId) {
        this.emailId = emailId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
