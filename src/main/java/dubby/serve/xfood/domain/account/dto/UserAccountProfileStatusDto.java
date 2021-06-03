package dubby.serve.xfood.domain.account.dto;

import dubby.serve.xfood.util.constants.AccountStatus;

public class UserAccountProfileStatusDto {

    private Long userAccountProfileStatusId;
    private AccountStatus accountStatus;

    public Long getUserAccountProfileStatusId() {
        return userAccountProfileStatusId;
    }

    public void setUserAccountProfileStatusId(Long userAccountProfileStatusId) {
        this.userAccountProfileStatusId = userAccountProfileStatusId;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }
}
