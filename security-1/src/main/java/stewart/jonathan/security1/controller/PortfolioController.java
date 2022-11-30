package stewart.jonathan.security1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortfolioController {

    @GetMapping("/portfolio")
    public String portfolio() {
        return "portfolio";
    }

//    @GetMapping("/")
//    public String home() {
//        return "Hello World";
//    }
//
//    @GetMapping("/user")
//    public String user() {
//        return "Hello user";
//    }
//
//    @GetMapping("/admin")
//    public String admin() {
//        return "Hello Admin";
//    }
}
