package dubby.serve.xfood.domain.account;

import dubby.serve.xfood.util.constants.EntityConst;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A Contact Details entity
 */
@Entity
@Table(name = EntityConst.CONTACT_DETAILS)
public class ContactDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = EntityConst.CONTACT_ID)
    private Long contactId;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull(message = EntityConst.NULL_MOBILE_NUMBER)
    @JoinColumn(name = EntityConst.MOBILE_NUMBER_ID, referencedColumnName = EntityConst.MOBILE_NUMBER_ID)
    private MobileNumber mobileNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull(message = EntityConst.NULL_EMAIL_ADDRESS)
    @JoinColumn(name = EntityConst.EMAIL_ID, referencedColumnName = EntityConst.EMAIL_ADDRESS_ID)
    private EmailAddress emailAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull(message = EntityConst.NULL_DEVICE_IP_ADDRESS)
    @JoinColumn(name = EntityConst.DEVICE_IP_ADDRESS_ID, referencedColumnName = EntityConst.IP_ADDRESS_ID)
    private DeviceIpAddress deviceIpAddress;

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public MobileNumber getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(MobileNumber mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public EmailAddress getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(EmailAddress emailAddress) {
        this.emailAddress = emailAddress;
    }

    public DeviceIpAddress getDeviceIpAddress() {
        return deviceIpAddress;
    }

    public void setDeviceIpAddress(DeviceIpAddress deviceIpAddress) {
        this.deviceIpAddress = deviceIpAddress;
    }
}
