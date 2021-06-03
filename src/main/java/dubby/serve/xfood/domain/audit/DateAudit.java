package dubby.serve.xfood.domain.audit;

import dubby.serve.xfood.util.constants.EntityConst;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class DateAudit {

    @CreatedDate
    @Column(name = EntityConst.CREATED_AT)
    @NotNull(message = EntityConst.NULL_CREATED_AT)
    private LocalDateTime createdAt;

    @Column(name = EntityConst.LAST_UNTIL)
    private LocalDateTime lastUntil;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getLastUntil() {
        return lastUntil;
    }

    public void setLastUntil(LocalDateTime lastUntil) {
        this.lastUntil = lastUntil;
    }

    @PrePersist
    protected void beforePersistingCreatedAt() {
        if (createdAt == null ) createdAt = LocalDateTime.now();
    }
}
