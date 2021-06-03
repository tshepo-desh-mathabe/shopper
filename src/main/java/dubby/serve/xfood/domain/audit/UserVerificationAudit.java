package dubby.serve.xfood.domain.audit;

import dubby.serve.xfood.util.constants.EntityConst;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class UserVerificationAudit {

    @Id
    @CreatedBy
    @Column(name = EntityConst.FOR_USER_ID)
    @NotNull(message = EntityConst.NULL_CREATED_AT_ID)
    private Long createdBy;

    @NotNull
    @CreatedDate
    @Column(name = EntityConst.CREATED_AT)
    private LocalDateTime createdAt;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

}