package dubby.serve.xfood.domain.globe.dto;

public class ImagePocketDto {
    private Long imagePocketId;
    private String name;
    private String description;
    private Byte[] image;
    private UseGloballyDto useGloballyDto;

    public Long getImagePocketId() {
        return imagePocketId;
    }

    public void setImagePocketId(Long imagePocketId) {
        this.imagePocketId = imagePocketId;
    }

    public String getImageName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageDescription() {
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

    public UseGloballyDto getUseGloballyDto() {
        return useGloballyDto;
    }

    public void setUseGloballyDto(UseGloballyDto useGloballyDto) {
        this.useGloballyDto = useGloballyDto;
    }
}
