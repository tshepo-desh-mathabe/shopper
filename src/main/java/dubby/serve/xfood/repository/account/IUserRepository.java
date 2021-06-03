package dubby.serve.xfood.repository.account;

import dubby.serve.xfood.domain.account.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * A User CRUD operator
 */
@Repository
public interface IUserRepository extends CrudRepository<User, Long> {

    boolean existsByKnownAs(String username);

    Optional<User> findByKnownAsOrContactDetailsEmailAddressAddress(String username, String email);
    
}
