package stewart.jonathan.security1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Hello World";
    }

    @GetMapping("/user")
    public String user(Principal principal) {
        return "Hello " + principal.getName();
    }

    @GetMapping("/admin")
    public String admin() {
        return "Hello Admin";
    }
}
