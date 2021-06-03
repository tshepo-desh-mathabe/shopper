package dubby.serve.xfood.resource;


import dubby.serve.xfood.util.constants.ServicePath;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = ServicePath.BASE_DOMAIN_SERVICE)
@RequestMapping(ServicePath.PRODUCT_ENTRY_POINT)
public class ProductController {
}
