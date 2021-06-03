package dubby.serve.xfood.domain.account.dto;

import dubby.serve.xfood.domain.audit.dto.DateAuditDto;

public class AccountNonExpiredDto extends DateAuditDto {

    private Long accountNonExpiredId;
    private Boolean isExpired;

    public AccountNonExpiredDto() {}

    public AccountNonExpiredDto(Boolean isExpired) {
        this.isExpired = isExpired;
    }

    public Long getAccountNonExpiredId() {
        return accountNonExpiredId;
    }

    public void setAccountNonExpiredId(Long accountNonExpiredId) {
        this.accountNonExpiredId = accountNonExpiredId;
    }

    public Boolean getExpired() {
        return isExpired;
    }

    public void setExpired(Boolean expired) {
        isExpired = expired;
    }
}
