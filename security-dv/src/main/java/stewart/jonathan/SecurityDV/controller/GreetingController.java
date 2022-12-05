package stewart.jonathan.SecurityDV.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class GreetingController {

    @GetMapping("/greet")
    public String greet() {
        return "Greetings";
    }

    @GetMapping("/home")
    public String home(Principal principal) {
        return "Welcome " + principal.getName();
    }
}
