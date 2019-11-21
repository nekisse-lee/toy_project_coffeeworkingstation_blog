package com.nekisse.coffeeworkstation.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {



    @GetMapping("/")
    public String home3() {
        return "home";
    }

    @GetMapping("/test2")
    @ResponseBody
    String home() {
        return "Happy Coding!";
    }

}


