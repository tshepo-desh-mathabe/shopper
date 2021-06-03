package dubby.serve.xfood.domain.store.dto;

import dubby.serve.xfood.domain.globe.dto.LocationDetailsDto;

public class StoreDetailsDto {

    private Long storeId;
    private StoreNameDto storeNameDetails;
    private LocationDetailsDto storeLocationDetails;

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public StoreNameDto getStoreNameDetails() {
        return storeNameDetails;
    }

    public void setStoreNameDetails(StoreNameDto storeNameDetails) {
        this.storeNameDetails = storeNameDetails;
    }

    public LocationDetailsDto getStoreLocationDetails() {
        return storeLocationDetails;
    }

    public void setStoreLocationDetails(LocationDetailsDto storeLocationDetails) {
        this.storeLocationDetails = storeLocationDetails;
    }
}
