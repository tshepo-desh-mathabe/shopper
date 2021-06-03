package dubby.serve.xfood.domain.audit.dto;

import java.time.LocalDateTime;

/**
 * A Date  DTO
 */
public abstract class CreateUpdateDateAuditDto {

    private LocalDateTime createdAtDate;

    private LocalDateTime updatedAtDate;

    public LocalDateTime getCreatedAtDate() {
        return createdAtDate;
    }

    public void setCreatedAtDate(LocalDateTime createdAtDate) {
        this.createdAtDate = createdAtDate;
    }

    public LocalDateTime getUpdatedAtDate() {
        return updatedAtDate;
    }

    public void setUpdatedAtDate(LocalDateTime updatedAtDate) {
        this.updatedAtDate = updatedAtDate;
    }
}
