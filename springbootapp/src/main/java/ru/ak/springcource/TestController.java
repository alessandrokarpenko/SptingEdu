package ru.ak.springcource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        System.out.println("hello");
        return "hello";
    }
}
