package configrations.starup.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/spring")
public class TestSpring {

    @RequestMapping("/home")
    String springHome(HttpServletRequest request){
        request.setAttribute("message","spring is configured correctly");
        return "startupSpring";
    }

}
