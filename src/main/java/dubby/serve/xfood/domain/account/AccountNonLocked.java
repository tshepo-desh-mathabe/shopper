package dubby.serve.xfood.domain.account;

import dubby.serve.xfood.domain.audit.DateAudit;
import dubby.serve.xfood.util.constants.EntityConst;

import javax.persistence.*;

@Entity
@Table(name = EntityConst.ACCOUNT_NON_LOCKED)
public class AccountNonLocked extends DateAudit {

    @Id
    @Column(name = EntityConst.ACCOUNT_LOCKED_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = EntityConst.IS_ACCOUNT_LOCKED,
            nullable = false,
            columnDefinition = EntityConst.TINYINT,
            length = 1
    )
    private Boolean isAccountNonLocked;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getAccountNonLocked() {
        return isAccountNonLocked;
    }

    public void setAccountNonLocked(Boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
    }
}
