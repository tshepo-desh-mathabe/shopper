package dubby.serve.xfood.domain.globe;

import dubby.serve.xfood.util.constants.EntityConst;

import javax.persistence.*;

@Entity
@Table(name = EntityConst.USE_GLOBALLY, uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                EntityConst.IS_GLOBAL
        })
})
public class UseGlobally {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = EntityConst.USE_GLOBALLY_ID)
    private Long id;

    @Column(
            name = EntityConst.IS_GLOBAL,
            nullable = false,
            columnDefinition = EntityConst.TINYINT,
            length = 1
    )
    private Boolean isGlobal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getGlobal() {
        return isGlobal;
    }

    public void setGlobal(Boolean global) {
        isGlobal = global;
    }
}
