package dubby.serve.xfood.domain.globe;

import dubby.serve.xfood.util.constants.EntityConst;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = EntityConst.LOCATION_DETAILS)
public class LocationDetails {

    @Id
    @Column(name = EntityConst.LOCATION_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Column(name = EntityConst.LONGITUDE)
    private Double longitude;

    @NotNull
    @NotBlank
    @Column(name = EntityConst.ALTITUDE)
    private Double altitude;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getAltitude() {
        return altitude;
    }

    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }
}
