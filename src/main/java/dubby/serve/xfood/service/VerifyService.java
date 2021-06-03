package dubby.serve.xfood.service;

import dubby.serve.xfood.domain.emailverification.dto.VerifyDto;
import dubby.serve.xfood.util.helper.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Sign-up service used strictly by the controller
 */
@Service
public class VerifyService {

    @Autowired
    private IService<VerifyDto> service;

    public void deleteVerification(String token) {
        service.deleteData(token);
    }
}
