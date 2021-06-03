package dubby.serve.xfood.domain.emailverification;

import dubby.serve.xfood.domain.audit.UserVerificationAudit;
import dubby.serve.xfood.util.constants.EntityConst;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = EntityConst.ACCOUNT_VERIFICATION, uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                EntityConst.VERIFICATION_TOKEN,
        })
})
public class Verify extends UserVerificationAudit implements Serializable {

    @NotBlank
    @Size(max = 150)
    @Column(name = EntityConst.VERIFICATION_TOKEN)
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
