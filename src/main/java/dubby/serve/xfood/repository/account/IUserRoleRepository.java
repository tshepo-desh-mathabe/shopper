package dubby.serve.xfood.repository.account;

import dubby.serve.xfood.domain.account.UserRole;
import dubby.serve.xfood.util.constants.RoleType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * A User Role CRUD operator
 */
@Repository
public interface IUserRoleRepository extends CrudRepository<UserRole, Long> {

    UserRole findByRoleType(RoleType type);

}
