package dubby.serve.xfood.repository.account;

import dubby.serve.xfood.domain.account.EmailAddress;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * A Email Address CRUD operator
 */
@Repository
public interface IEmailAddressRepository extends CrudRepository<EmailAddress, Long> {

    boolean existsByAddress(String emailAddress);
}