package live.daniel.study;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Daniel on 13.09.2017.
 */
@RestController
public class Controller {

    @RequestMapping("/")
    public String index() {
        return "Hello";
    }
}
