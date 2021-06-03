package dubby.serve.xfood.domain.account.dto;

import dubby.serve.xfood.domain.audit.dto.DateAuditDto;

public class AccountNonLockedDto extends DateAuditDto {

    private Long accountNonLockedId;
    private Boolean isNotLocked;

    public AccountNonLockedDto() {}

    public AccountNonLockedDto(Boolean isNotLocked) {
        this.isNotLocked = isNotLocked;
    }

    public Long getAccountNonLockedId() {
        return accountNonLockedId;
    }

    public void setAccountNonLockedId(Long accountNonLockedId) {
        this.accountNonLockedId = accountNonLockedId;
    }

    public Boolean getNotLocked() {
        return isNotLocked;
    }

    public void setNotLocked(Boolean notLocked) {
        isNotLocked = notLocked;
    }
}
