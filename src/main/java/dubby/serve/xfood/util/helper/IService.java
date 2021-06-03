package dubby.serve.xfood.util.helper;

import org.springframework.http.ResponseEntity;

/**
 * Service operator logic
 * @param <D> - a DTO object
 */
public interface IService<D> {

    default ResponseEntity<?> saveData(D dto) {
        return null;
    }

    default void storeData(D dto) {}

    default void deleteData(String token) {}

}
