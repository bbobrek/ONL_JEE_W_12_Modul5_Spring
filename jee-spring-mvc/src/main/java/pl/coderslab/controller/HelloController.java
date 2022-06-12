package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;

@Controller
public class HelloController {

    @GetMapping(value = "/hello/{firstName}/{lastName}", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String hello(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
        return "Witaj " + firstName + " " + lastName;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloWorld() {
        return "Hello world";
    }

    @GetMapping("/helloView")
    public String helloView(Model model) {
        LocalTime actualTime = LocalTime.now();
        if (actualTime.isAfter(LocalTime.of(8, 0)) &&
                actualTime.isBefore(LocalTime.of(20, 0))) {
            model.addAttribute("color", "black");
            model.addAttribute("backgroundColor", "white");
        } else {
            model.addAttribute("color", "white");
            model.addAttribute("backgroundColor", "black");
        }
        return "home";
        // dzieki konfiguracji bedzie /WEB-INF/views/home.jsp
    }

}
