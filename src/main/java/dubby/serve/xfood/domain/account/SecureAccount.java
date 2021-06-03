package dubby.serve.xfood.domain.account;

import dubby.serve.xfood.util.constants.EntityConst;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = EntityConst.SECURE_ACCOUNT)
public class SecureAccount {

    @Id
    @Column(name = EntityConst.SECURE_ACCOUNT_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull(message = EntityConst.NULL_ACCOUNT_ENABLED)
    @JoinColumn(name = EntityConst.ACCOUNT_ENABLED_ID, referencedColumnName = EntityConst.ACCOUNT_ENABLED_ID)
    private AccountEnabled accountEnabled;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull(message = EntityConst.NULL_ACCOUNT_NON_EXPIRED)
    @JoinColumn(name = EntityConst.ACCOUNT_EXPIRED_ID, referencedColumnName = EntityConst.ACCOUNT_EXPIRED_ID)
    private AccountNonExpired accountNonExpired;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull(message = EntityConst.NULL_CREDENTIAL_NON_EXPIRED)
    @JoinColumn(name = EntityConst.CREDENTIAL_EXPIRED_ID, referencedColumnName = EntityConst.CREDENTIAL_EXPIRED_ID)
    private CredentialsNonExpired credentialsNonExpired;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull(message = EntityConst.NULL_ACCOUNT_NON_LOCKED)
    @JoinColumn(name = EntityConst.ACCOUNT_LOCKED_ID, referencedColumnName = EntityConst.ACCOUNT_LOCKED_ID)
    private AccountNonLocked accountNonLocked;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull(message = EntityConst.NULL_USER_ACCOUNT_STATUS)
    @JoinColumn(name = EntityConst.USER_ACCOUNT_STATUS_ID, referencedColumnName = EntityConst.ACCOUNT_STATUS_ID)
    private UserAccountStatus userAccountStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccountEnabled getAccountEnabled() {
        return accountEnabled;
    }

    public void setAccountEnabled(AccountEnabled accountEnabled) {
        this.accountEnabled = accountEnabled;
    }

    public AccountNonExpired getAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(AccountNonExpired accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public CredentialsNonExpired getCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(CredentialsNonExpired credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public AccountNonLocked getAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(AccountNonLocked accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public UserAccountStatus getUserAccountStatus() {
        return userAccountStatus;
    }

    public void setUserAccountStatus(UserAccountStatus userAccountStatus) {
        this.userAccountStatus = userAccountStatus;
    }
}
