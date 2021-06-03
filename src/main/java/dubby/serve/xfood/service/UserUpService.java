package dubby.serve.xfood.service;

import dubby.serve.xfood.domain.account.dto.UserDto;
import dubby.serve.xfood.util.helper.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Sign-up service used strictly by the controller
 */
@Service
public class UserUpService {

    @Autowired
    private IService<UserDto> service;

    public ResponseEntity<?> createUser(UserDto userRequest) {
        return service.saveData(userRequest);
    }
}
