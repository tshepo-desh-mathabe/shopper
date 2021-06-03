package dubby.serve.xfood.domain.account.dto;

public class SecureAccountDto {

    private Long secureAccountId;
    private AccountEnabledDto accountEnabledDetails;
    private AccountNonExpiredDto accountNonExpiredDetails;
    private CredentialsNonExpiredDto credentialsNonExpiredDetails;
    private AccountNonLockedDto accountNonLockedDetails;
    private UserAccountStatusDto userAccountStatusDetails;

    public Long getSecureAccountId() {
        return secureAccountId;
    }

    public void setSecureAccountId(Long secureAccountId) {
        this.secureAccountId = secureAccountId;
    }

    public AccountEnabledDto getAccountEnabledDetails() {
        return accountEnabledDetails;
    }

    public void setAccountEnabledDetails(AccountEnabledDto accountEnabledDetails) {
        this.accountEnabledDetails = accountEnabledDetails;
    }

    public AccountNonExpiredDto getAccountNonExpiredDetails() {
        return accountNonExpiredDetails;
    }

    public void setAccountNonExpiredDetails(AccountNonExpiredDto accountNonExpiredDetails) {
        this.accountNonExpiredDetails = accountNonExpiredDetails;
    }

    public CredentialsNonExpiredDto getCredentialsNonExpiredDetails() {
        return credentialsNonExpiredDetails;
    }

    public void setCredentialsNonExpiredDetails(CredentialsNonExpiredDto credentialsNonExpiredDetails) {
        this.credentialsNonExpiredDetails = credentialsNonExpiredDetails;
    }

    public AccountNonLockedDto getAccountNonLockedDetails() {
        return accountNonLockedDetails;
    }

    public void setAccountNonLockedDetails(AccountNonLockedDto accountNonLockedDetails) {
        this.accountNonLockedDetails = accountNonLockedDetails;
    }

    public UserAccountStatusDto getUserAccountStatusDetails() {
        return userAccountStatusDetails;
    }

    public void setUserAccountStatusDetails(UserAccountStatusDto userAccountStatusDetails) {
        this.userAccountStatusDetails = userAccountStatusDetails;
    }
}
