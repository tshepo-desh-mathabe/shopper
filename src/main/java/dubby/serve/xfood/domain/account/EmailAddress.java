package dubby.serve.xfood.domain.account;

import dubby.serve.xfood.util.constants.EntityConst;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A Email Address entity
 */
@Entity
@Table(name = EntityConst.EMAIL_ADDRESS, uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                EntityConst.EMAIL
        })
})
public class EmailAddress implements Serializable {

    @Id
    @Column(name = EntityConst.EMAIL_ADDRESS_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emailId;

    @Email
    @NotNull
    @NotBlank
    @Column(name = EntityConst.EMAIL)
    @Size(min = 10, max = 60, message = EntityConst.EMAIL_CONSTRAINT)
    private String address;

    public Long getEmailId() {
        return emailId;
    }

    public void setEmailId(Long emailId) {
        this.emailId = emailId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
