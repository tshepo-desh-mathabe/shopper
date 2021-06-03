package dubby.serve.xfood.domain.account;

import dubby.serve.xfood.util.constants.EntityConst;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A Mobile Number entity
 */
@Entity
@Table(name = EntityConst.MOBILE_NUMBER, uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                EntityConst.NUMBER
        })
})
public class MobileNumber implements Serializable {

    @Id
    @Column(name = EntityConst.MOBILE_NUMBER_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mobileNumberId;

    @NotNull
    @NotBlank
    @Column(name = EntityConst.NUMBER)
    @Size(min = 6, max = 9, message = EntityConst.NUMBER_CONSTRAINT)
    private String number;

    @OneToOne(cascade = CascadeType.MERGE)
    @NotNull(message = EntityConst.NULL_MOBILE_NUMBER_CODE)
    @JoinColumn(name = EntityConst.MOBILE_COUNTRY_CODE_ID, referencedColumnName = EntityConst.MOBILE_COUNTRY_CODE_ID)
    private MobileNumberCode mobileNumberCode;

    public Long getMobileNumberId() {
        return mobileNumberId;
    }

    public void setMobileNumberId(Long mobileNumberId) {
        this.mobileNumberId = mobileNumberId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public MobileNumberCode getMobileNumberCode() {
        return mobileNumberCode;
    }

    public void setMobileNumberCode(MobileNumberCode mobileNumberCode) {
        this.mobileNumberCode = mobileNumberCode;
    }
}
