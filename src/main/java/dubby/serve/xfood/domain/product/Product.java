package dubby.serve.xfood.domain.product;

import dubby.serve.xfood.domain.globe.UseGlobally;
import dubby.serve.xfood.domain.store.StoreDetails;
import dubby.serve.xfood.util.constants.EntityConst;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = EntityConst.PRODUCT)
public class Product {

    @Id
    @Column(name = EntityConst.PRODUCT_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Column(name = EntityConst.NAME)
    @Size(min = 2, max = 40, message = EntityConst.NAME)
    private String name;

    @NotNull
    @NotBlank
    @Column(name = EntityConst.TYPE)
    @Size(min = 2, max = 40, message = EntityConst.TYPE_CONSTRAINT)
    private String type;

    @NotBlank
    @Column(name = EntityConst.DESCRIPTION)
    @Size(max = 60, message = EntityConst.DESCRIPTION_CONSTRAINT)
    private String description;

    @NotNull
    @NotBlank
    @Column(name = EntityConst.PRICE)
    private Double price;

    @NotNull
    @NotBlank
    @Column(name = EntityConst.QUANTITY)
    private Integer quantity;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = EntityConst.PRODUCT_STORE_DETAILS,
            joinColumns = @JoinColumn(name = EntityConst.PRODUCT_ID),
            inverseJoinColumns = @JoinColumn(name = EntityConst.STORE_ID)
    )
    private List<StoreDetails> storeDetails;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<StoreDetails> getStoreDetails() {
        return storeDetails;
    }

    public void setStoreDetails(List<StoreDetails> storeDetails) {
        this.storeDetails = storeDetails;
    }

    public UseGlobally getUseGlobally() {
        return useGlobally;
    }

    public void setUseGlobally(UseGlobally useGlobally) {
        this.useGlobally = useGlobally;
    }
}
