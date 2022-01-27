package twotwo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class ThirdController {

    @GetMapping("/calculator")
    public String getResult(@RequestParam(value="a", required = true) int a,
                         @RequestParam(value="b", required = true) int b,
                         @RequestParam(value="action", required = false) String action,
                            Model model) {

        int result;

        switch (action) {
            case("multiplication"):
                result = a * b;
                break;
            case("addition"):
                result = a + b;
                break;
            case("subtraction"):
                result = a - b;
                break;
            case("division"):
                result = a / b;
                break;
            default:
                result = 92835;
        }

        model.addAttribute("result", "Result of " + a + " " + action + " " + b + " is " + result);

        return "third/calculator";
    }

}
