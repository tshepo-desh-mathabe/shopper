package dubby.serve.xfood.domain.account;

import dubby.serve.xfood.domain.audit.CreateUpdateDateAudit;
import dubby.serve.xfood.domain.globe.UseGlobally;
import dubby.serve.xfood.domain.store.StoreDetails;
import dubby.serve.xfood.util.constants.EntityConst;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * A User entity
 */
@Entity
@Table(name = EntityConst.USER, uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                EntityConst.USERNAME
        })
})
public class User extends CreateUpdateDateAudit implements Serializable {

    @Id
    @Column(name = EntityConst.USER_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Column(name = EntityConst.USERNAME)
    @Size(min = 2, max = 40, message = EntityConst.USERNAME_SIZE_CONSTRAINT)
    private String knownAs;

    @NotNull
    @NotBlank
    @Column(name = EntityConst.FIRST_NAME)
    @Size(min = 2, max = 40, message = EntityConst.FIRST_NAME_CONSTRAINT)
    private String firstName;

    @NotNull
    @NotBlank
    @Column(name = EntityConst.LAST_NAME)
    @Size(min = 2, max = 40, message = EntityConst.LAST_NAME_CONSTRAINT)
    private String lastName;

    @NotNull
    @NotBlank
    @Column(name = EntityConst.PASSWORD)
    @Size(min = 4, max = 70, message = EntityConst.PASSWORD_CONSTRAINT)
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull(message = EntityConst.NULL_SECURE_ACCOUNT_DETAILS)
    @JoinColumn(name = EntityConst.SECURE_ACCOUNT_ID, referencedColumnName = EntityConst.SECURE_ACCOUNT_ID)
    private SecureAccount secureAccount;

    @NotNull
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = EntityConst.ROLE_USER)
    private List<UserRole> roles;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull(message = EntityConst.NULL_CONTACT_DETAILS)
    @JoinColumn(name = EntityConst.CONTACT_DETAILS_ID, referencedColumnName = EntityConst.CONTACT_ID)
    private ContactDetails contactDetails;

    @NotNull
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = EntityConst.USER_STORE_DETAILS,
            joinColumns = @JoinColumn(name = EntityConst.USER_ID),
            inverseJoinColumns = @JoinColumn(name = EntityConst.STORE_ID)
    )
    private List<StoreDetails> storeDetails;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull(message = EntityConst.NULL_USE_GLOBAL)
    @JoinColumn(name = EntityConst.USE_GLOBAL_ID, referencedColumnName = EntityConst.USE_GLOBALLY_ID)
    private UseGlobally useGlobally;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKnownAs() {
        return knownAs;
    }

    public void setKnownAs(String knownAs) {
        this.knownAs = knownAs;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SecureAccount getSecureAccount() {
        return secureAccount;
    }

    public void setSecureAccount(SecureAccount secureAccount) {
        this.secureAccount = secureAccount;
    }

    public List<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }

    public List<StoreDetails> getStoreDetails() {
        return storeDetails;
    }

    public void setStoreDetails(List<StoreDetails> storeDetails) {
        this.storeDetails = storeDetails;
    }

    public UseGlobally getUseGlobally() {
        return useGlobally;
    }

    public void setUseGlobally(UseGlobally useGlobally) {
        this.useGlobally = useGlobally;
    }
}
