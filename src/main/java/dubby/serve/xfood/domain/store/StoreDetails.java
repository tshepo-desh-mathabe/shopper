package dubby.serve.xfood.domain.store;

import dubby.serve.xfood.domain.globe.LocationDetails;
import dubby.serve.xfood.util.constants.EntityConst;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = EntityConst.STORE_DETAILS)
public class StoreDetails {

    @Id
    @Column(name = EntityConst.STORE_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull(message = EntityConst.NULL_STORE_NAME)
    @JoinColumn(name = EntityConst.STORE_NAME_ID, referencedColumnName = EntityConst.STORE_NAME_ID)
    private StoreName storeName;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull(message = EntityConst.NULL_LOCATION_DETAILS)
    @JoinColumn(name = EntityConst.LOCATION_DETAILS_ID, referencedColumnName = EntityConst.LOCATION_ID)
    private LocationDetails locationDetails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StoreName getStoreName() {
        return storeName;
    }

    public void setStoreName(StoreName storeName) {
        this.storeName = storeName;
    }

    public LocationDetails getLocationDetails() {
        return locationDetails;
    }

    public void setLocationDetails(LocationDetails locationDetails) {
        this.locationDetails = locationDetails;
    }
}
