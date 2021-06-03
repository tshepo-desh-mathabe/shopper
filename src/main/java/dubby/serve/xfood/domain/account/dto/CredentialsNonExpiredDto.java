package dubby.serve.xfood.domain.account.dto;

import dubby.serve.xfood.domain.audit.dto.DateAuditDto;

public class CredentialsNonExpiredDto extends DateAuditDto {

    private Long credentialsNonExpiredId;
    private Boolean isExpired;

    public CredentialsNonExpiredDto() {}

    public CredentialsNonExpiredDto(Boolean isExpired) {
        this.isExpired = isExpired;
    }

    public Long getCredentialsNonExpiredId() {
        return credentialsNonExpiredId;
    }

    public void setCredentialsNonExpiredId(Long credentialsNonExpiredId) {
        this.credentialsNonExpiredId = credentialsNonExpiredId;
    }

    public Boolean getExpired() {
        return isExpired;
    }

    public void setExpired(Boolean expired) {
        isExpired = expired;
    }
}
