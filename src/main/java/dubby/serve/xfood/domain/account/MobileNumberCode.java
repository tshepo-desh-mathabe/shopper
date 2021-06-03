package dubby.serve.xfood.domain.account;

import dubby.serve.xfood.util.constants.EntityConst;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A Mobile Country Code entity
 */
@Entity
@Table(name = EntityConst.MOBILE_NUMBER_CODE, uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                EntityConst.MOBILE_NUMBER_CODE
        })
})
public class MobileNumberCode implements Serializable {

    @Id
    @Column(name = EntityConst.MOBILE_COUNTRY_CODE_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numberCodeId;

    @NotNull
    @NotBlank
    @Column(name = EntityConst.MOBILE_NUMBER_CODE)
    @Size(min = 3, max = 6, message = EntityConst.NUMBER_CODE_CONSTRAINT)
    private String numberCode;

    public Long getNumberCodeId() {
        return numberCodeId;
    }

    public void setNumberCodeId(Long numberCodeId) {
        this.numberCodeId = numberCodeId;
    }

    public String getNumberCode() {
        return numberCode;
    }

    public void setNumberCode(String numberCode) {
        this.numberCode = numberCode;
    }
}
