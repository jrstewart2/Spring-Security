package stewart.jonathan.Spring.Security.CORS.Tutorial.controller;

import org.springframework.web.bind.annotation.*;
import stewart.jonathan.Spring.Security.CORS.Tutorial.model.Coffee;
import stewart.jonathan.Spring.Security.CORS.Tutorial.model.Size;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/coffee")
// @CrossOrigin(origins = "http://localhost:3000")   class level of access
public class CoffeeController {

    private List<Coffee> coffeeList = new ArrayList<>();

    public CoffeeController() {
        coffeeList.add(new Coffee(1, "Café Americano", Size.GRANDE));
        coffeeList.add(new Coffee(2, "Café Latté", Size.VENTI));
        coffeeList.add(new Coffee(3, "Café Macchiato", Size.TALL));
    }

    // @CrossOrigin     method level of access
    @GetMapping
    public List<Coffee> findAll() {
        return coffeeList;
    }

    // @CrossOrigin(origins = "http://localhost:3000") method level of access
    @DeleteMapping
    public void delete(Integer id) {
        coffeeList.removeIf(coffee -> coffee.id().equals(id));
    }

}
