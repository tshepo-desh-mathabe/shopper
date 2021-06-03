package dubby.serve.xfood.repository.emailverification;

import dubby.serve.xfood.domain.emailverification.Verify;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IVerifyRepository extends CrudRepository<Verify, Long> {

    Boolean existsByToken(String token);

    void deleteByToken(String token);

    Optional<Verify> findByToken(String token);
}