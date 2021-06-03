package dubby.serve.xfood.domain.account.dto;

import dubby.serve.xfood.domain.audit.DateAudit;

public class UserAccountStatusDto extends DateAudit {

    private Long userAccountStatusId;
    private String userAccountStatusReason;
    private UserAccountProfileStatusDto userAccountProfileStatusDetails;

    public UserAccountStatusDto() {}

    public UserAccountStatusDto(String userAccountStatusReason, UserAccountProfileStatusDto userAccountProfileStatusDetails) {
        this.userAccountStatusReason = userAccountStatusReason;
        this.userAccountProfileStatusDetails = userAccountProfileStatusDetails;
    }

    public Long getUserAccountStatusId() {
        return userAccountStatusId;
    }

    public void setUserAccountStatusId(Long userAccountStatusId) {
        this.userAccountStatusId = userAccountStatusId;
    }

    public String getUserAccountStatusReason() {
        return userAccountStatusReason;
    }

    public void setUserAccountStatusReason(String userAccountStatusReason) {
        this.userAccountStatusReason = userAccountStatusReason;
    }

    public UserAccountProfileStatusDto getUserAccountProfileStatusDetails() {
        return userAccountProfileStatusDetails;
    }

    public void setUserAccountProfileStatusDetails(UserAccountProfileStatusDto userAccountProfileStatusDetails) {
        this.userAccountProfileStatusDetails = userAccountProfileStatusDetails;
    }
}
