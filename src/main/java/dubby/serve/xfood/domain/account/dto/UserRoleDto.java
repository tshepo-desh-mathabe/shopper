package dubby.serve.xfood.domain.account.dto;

/**
 * A User Role DTO
 */
public class UserRoleDto {

    private Long roleId;
    private String type;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
