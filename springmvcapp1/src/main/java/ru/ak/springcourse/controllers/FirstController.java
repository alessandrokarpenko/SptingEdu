package ru.ak.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

        //System.out.println("Hello, " + name + " " + surname);
        model.addAttribute("message", "Hello, " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

    @GetMapping("/calc")
    public String calc(@RequestParam(value = "a") int a,
                       @RequestParam(value = "b") int b,
                       @RequestParam(value = "act") String act,
                       Model model) {

        double result;

        switch (act) {
            case "add":
                result = a+b;
                break;
            case "sub":
                result = a-b;
                break;
            case "mul":
                result = a*b;
                break;
            case "div":
                result = (double) a/b;
                break;
            default:
                result = Double.NaN;
        }
        model.addAttribute("result", result);

        return "first/calc";
    }
}
