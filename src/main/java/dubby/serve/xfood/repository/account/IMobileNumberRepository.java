package dubby.serve.xfood.repository.account;

import dubby.serve.xfood.domain.account.MobileNumber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * A Mobile Number CRUD operator
 */
@Repository
public interface IMobileNumberRepository extends CrudRepository<MobileNumber, Long> {

    boolean existsByNumber(String mobileNumber);
}