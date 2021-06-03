package dubby.serve.xfood.repository.account;

import dubby.serve.xfood.domain.account.UserAccountProfileStatus;
import dubby.serve.xfood.util.constants.AccountStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * A User Role CRUD operator
 */
@Repository
public interface IUserAccountProfileStatusRepository extends CrudRepository<UserAccountProfileStatus, Long> {

    UserAccountProfileStatus getByAccountStatus(AccountStatus accountStatusValue);

}
