package dubby.serve.xfood.domain.account;

import dubby.serve.xfood.util.constants.EntityConst;
import dubby.serve.xfood.util.constants.RoleType;

import javax.persistence.*;
import java.io.Serializable;

/**
 * A User Role entity
 */
@Entity
@Table(name = EntityConst.ROLE, uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                EntityConst.NAME
        })
})
public class UserRole implements Serializable {

    @Id
    @Column(name = EntityConst.ROLE_ID, length = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = EntityConst.NAME, nullable = false, length = 15)
    private RoleType roleType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }
}
