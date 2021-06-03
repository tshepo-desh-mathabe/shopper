package dubby.serve.xfood.domain.audit.dto;

import java.time.LocalDateTime;

public class DateAuditDto {

    private LocalDateTime createdAtDate;
    private LocalDateTime lastUntilDate;

    public LocalDateTime getCreatedAtDate() {
        return createdAtDate;
    }

    public void setCreatedAtDate(LocalDateTime createdAtDate) {
        this.createdAtDate = createdAtDate;
    }

    public LocalDateTime getLastUntilDate() {
        return lastUntilDate;
    }

    public void setLastUntilDate(LocalDateTime lastUntilDate) {
        this.lastUntilDate = lastUntilDate;
    }
}
