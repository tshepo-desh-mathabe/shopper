package dubby.serve.xfood.domain.account;

import dubby.serve.xfood.domain.audit.DateAudit;
import dubby.serve.xfood.util.constants.EntityConst;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A User Account Status
 */
@Entity
@Table(name = EntityConst.USER_ACCOUNT_STATUS)
public class UserAccountStatus extends DateAudit implements Serializable {
        @Id
        @Column(name = EntityConst.ACCOUNT_STATUS_ID)
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Size(max = 60)
        @Column(name = EntityConst.REASON)
        private String reason;

        @OneToOne
        @NotNull(message = EntityConst.NULL_PROFILE_STATUS)
        @JoinColumn(name = EntityConst.PROFILE_STATUS_ID, referencedColumnName = EntityConst.PROFILE_STATUS_ID)
        private UserAccountProfileStatus userAccountProfileStatus;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getReason() {
                return reason;
        }

        public void setReason(String reason) {
                this.reason = reason;
        }

        public UserAccountProfileStatus getUserAccountProfileStatus() {
                return userAccountProfileStatus;
        }

        public void setUserAccountProfileStatus(UserAccountProfileStatus userAccountProfileStatus) {
                this.userAccountProfileStatus = userAccountProfileStatus;
        }
}
