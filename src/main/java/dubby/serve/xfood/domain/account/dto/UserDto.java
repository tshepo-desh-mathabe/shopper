package dubby.serve.xfood.domain.account.dto;

import dubby.serve.xfood.domain.audit.dto.CreateUpdateDateAuditDto;
import dubby.serve.xfood.domain.globe.UseGlobally;
import dubby.serve.xfood.domain.globe.dto.UseGloballyDto;
import dubby.serve.xfood.domain.store.StoreDetails;
import dubby.serve.xfood.domain.store.dto.StoreDetailsDto;
import dubby.serve.xfood.util.constants.EntityConst;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * A User DTO
 */
public class UserDto extends CreateUpdateDateAuditDto {

    private Long userId;
    private String knownAs;
    private String firstName;
    private String lastName;
    private String pwd;
    private SecureAccountDto secureAccountDetails;
    private List<UserRoleDto> userRoleDetails;
    private ContactDetailsDto contactDetails;
    private List<StoreDetailsDto> userStoreDetails;
    private UseGloballyDto useUserGlobally;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public SecureAccountDto getSecureAccountDetails() {
        return secureAccountDetails;
    }

    public void setSecureAccountDetails(SecureAccountDto secureAccountDetails) {
        this.secureAccountDetails = secureAccountDetails;
    }

    public List<UserRoleDto> getUserRoleDetails() {
        return userRoleDetails;
    }

    public void setUserRoleDetails(List<UserRoleDto> userRoleDetails) {
        this.userRoleDetails = userRoleDetails;
    }

    public ContactDetailsDto getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ContactDetailsDto contactDetails) {
        this.contactDetails = contactDetails;
    }

    public List<StoreDetailsDto> getUserStoreDetails() {
        return userStoreDetails;
    }

    public void setUserStoreDetails(List<StoreDetailsDto> userStoreDetails) {
        this.userStoreDetails = userStoreDetails;
    }

    public UseGloballyDto getUseUserGlobally() {
        return useUserGlobally;
    }

    public void setUseUserGlobally(UseGloballyDto useUserGlobally) {
        this.useUserGlobally = useUserGlobally;
    }
}
