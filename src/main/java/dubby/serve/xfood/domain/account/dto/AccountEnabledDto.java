package dubby.serve.xfood.domain.account.dto;

import dubby.serve.xfood.domain.audit.dto.DateAuditDto;

public class AccountEnabledDto extends DateAuditDto {

    private Long accountEnabledId;
    private Boolean isEnabled;

    public AccountEnabledDto() {}

    public AccountEnabledDto(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public Long getAccountEnabledId() {
        return accountEnabledId;
    }

    public void setAccountEnabledId(Long accountEnabledId) {
        this.accountEnabledId = accountEnabledId;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }
}
