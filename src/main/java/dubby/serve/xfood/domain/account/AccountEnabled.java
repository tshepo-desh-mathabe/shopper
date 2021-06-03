package dubby.serve.xfood.domain.account;

import dubby.serve.xfood.domain.audit.DateAudit;
import dubby.serve.xfood.util.constants.EntityConst;
import dubby.serve.xfood.util.property_fetcher.IPropertyFetcher;

import javax.persistence.*;

@Entity
@Table(name = EntityConst.ACCOUNT_ENABLED)
public class AccountEnabled extends DateAudit {

    @Id
    @Column(name = EntityConst.ACCOUNT_ENABLED_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = EntityConst.IS_ENABLED,
            nullable = false,
            columnDefinition = EntityConst.TINYINT,
            length = 1
    )
    private Boolean isEnabled;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }
}
