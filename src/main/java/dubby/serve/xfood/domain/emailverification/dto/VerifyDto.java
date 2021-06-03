package dubby.serve.xfood.domain.emailverification.dto;

import dubby.serve.xfood.domain.audit.dto.UserVerificationAuditDto;

public class VerifyDto extends UserVerificationAuditDto {

    private Long userId;
    private String verificationToken;
    private String emailAddress;
    private String fullName;

    public VerifyDto() {}

    public VerifyDto(Long userId, String emailAddress, String fullName) {
        this.userId = userId;
        this.emailAddress = emailAddress;
        this.fullName = fullName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getVerificationToken() {
        return verificationToken;
    }

    public void setVerificationToken(String verificationToken) {
        this.verificationToken = verificationToken;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}