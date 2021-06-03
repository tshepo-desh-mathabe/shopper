package dubby.serve.xfood.domain.globe;


import dubby.serve.xfood.util.constants.EntityConst;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = EntityConst.IMAGE_POCKED, uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                EntityConst.NAME
        })
})
public class ImagePocket {

    @Id
    @Column(name = EntityConst.IMAGE_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Column(name = EntityConst.NAME)
    @Size(min = 2, max = 40, message = EntityConst.NAME_SIZE_CONSTRAINT)
    private String name;

    @NotBlank
    @Column(name = EntityConst.DESCRIPTION)
    @Size(min = 3, max = 60, message = EntityConst.DESCRIPTION_CONSTRAINT)
    private String description;

    @NotNull
    @NotBlank
    @Column(name = EntityConst.IMAGE)
    private Byte[] image;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull(message = EntityConst.NULL_USE_GLOBAL)
    @JoinColumn(name = EntityConst.USE_GLOBAL_ID, referencedColumnName = EntityConst.USE_GLOBALLY_ID)
    private UseGlobally useGlobally;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public UseGlobally getUseGlobally() {
        return useGlobally;
    }

    public void setUseGlobally(UseGlobally useGlobally) {
        this.useGlobally = useGlobally;
    }
}
