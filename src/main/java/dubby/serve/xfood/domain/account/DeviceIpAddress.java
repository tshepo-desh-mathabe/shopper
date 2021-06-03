package dubby.serve.xfood.domain.account;

import dubby.serve.xfood.util.constants.EntityConst;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A DeviceIpAddressDto entity
 */
@Entity
@Table(name = EntityConst.DEVICE_IP_ADDRESS, uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                EntityConst.IP_ADDRESS
        })
})
public class DeviceIpAddress implements Serializable {

    @Id
    @Column(name = EntityConst.IP_ADDRESS_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @NotBlank
    @NotNull(message = EntityConst.NULL_IP_ADDRESS)
    @Column(name = EntityConst.IP_ADDRESS, length = 40)
    private String ipAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
