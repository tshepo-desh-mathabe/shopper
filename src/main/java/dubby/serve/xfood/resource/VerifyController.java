package dubby.serve.xfood.resource;

import dubby.serve.xfood.service.VerifyService;
import dubby.serve.xfood.util.constants.ServicePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = ServicePath.BASE_DOMAIN_SERVICE)
@RequestMapping(ServicePath.VERIFY_ENTRY_POINT)
public class VerifyController {

    @Autowired
    private VerifyService verifyService;

    @DeleteMapping(ServicePath.DELETE_BY_ID)
    public void deleteEmailVerification(@PathVariable("id") String token) {
        verifyService.deleteVerification(token);
    }
}