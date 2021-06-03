package dubby.serve.xfood.domain.store;

import dubby.serve.xfood.util.constants.EntityConst;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = EntityConst.STORE_NAME_DETAILS, uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                EntityConst.NAME
        })
})
public class StoreName {

    @Id
    @Column(name = EntityConst.STORE_NAME_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Column(name = EntityConst.NAME)
    @Size(min = 2, max = 40, message = EntityConst.NAME_SIZE_CONSTRAINT)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
