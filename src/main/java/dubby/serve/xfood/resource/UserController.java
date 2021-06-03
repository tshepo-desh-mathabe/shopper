package dubby.serve.xfood.resource;

import dubby.serve.xfood.domain.account.dto.UserDto;
import dubby.serve.xfood.service.UserUpService;
import dubby.serve.xfood.util.constants.ServicePath;
import dubby.serve.xfood.util.response.ResponseApiWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A sign-up controller API end point
 */
@RestController
//@CrossOrigin(origins = ServicePath.BASE_DOMAIN_SERVICE)
@RequestMapping(ServicePath.USER_ENTRY_POINT)
public class UserController {

    @Autowired
    private UserUpService userUpService;

    @PostMapping(ServicePath.SAVE_POINT)
    public ResponseEntity<?> saveUser(@RequestBody UserDto userRequest) {
        try {
            return userUpService.createUser(userRequest);
        } catch (ConstraintViolationException e) {
            List<String> violations = e.getConstraintViolations()
                                    .stream()
                                    .map(i -> i.getMessageTemplate())
                                    .collect(Collectors.toList());

            return new ResponseApiWrapper().badRequest(violations);
        }
    }

}
