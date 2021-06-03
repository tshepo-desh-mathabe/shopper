package dubby.serve.xfood.domain.account;

import dubby.serve.xfood.domain.audit.DateAudit;
import dubby.serve.xfood.util.constants.EntityConst;

import javax.persistence.*;

@Entity
@Table(name = EntityConst.ACCOUNT_NON_EXPIRED)
public class AccountNonExpired extends DateAudit {

    @Id
    @Column(name = EntityConst.ACCOUNT_EXPIRED_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = EntityConst.IS_ACCOUNT_EXPIRED,
            nullable = false,
            columnDefinition = EntityConst.TINYINT,
            length = 1
    )
    private Boolean isAccountExpired;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getAccountExpired() {
        return isAccountExpired;
    }

    public void setAccountExpired(Boolean accountExpired) {
        isAccountExpired = accountExpired;
    }
}
