package dubby.serve.xfood.domain.account;

import dubby.serve.xfood.domain.audit.DateAudit;
import dubby.serve.xfood.util.constants.EntityConst;

import javax.persistence.*;

@Entity
@Table(name = EntityConst.CREDENTIALS_NON_EXPIRED)
public class CredentialsNonExpired extends DateAudit {

    @Id
    @Column(name = EntityConst.CREDENTIAL_EXPIRED_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = EntityConst.IS_CREDENTIALS_EXPIRED,
            nullable = false,
            columnDefinition = EntityConst.TINYINT,
            length = 1
    )
    private Boolean isCredentialsExpired;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getCredentialsExpired() {
        return isCredentialsExpired;
    }

    public void setCredentialsExpired(Boolean credentialsExpired) {
        isCredentialsExpired = credentialsExpired;
    }
}
