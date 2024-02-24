package id.ac.ui.cs.advprog.eshop.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("")
public class AppController {
    @GetMapping("/")
    public String getMain(){
        return "index";
    }
}
