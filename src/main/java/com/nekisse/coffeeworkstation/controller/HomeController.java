package com.nekisse.coffeeworkstation.controller;


import com.nekisse.coffeeworkstation.domain.InstaDomain;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.nekisse.coffeeworkstation.utils.InstagramUtils.getInstaImgAndDesc;

@Controller
public class HomeController {


    @GetMapping("/")
    public String home3(Model model) throws IOException {
        Map<String, String> map = new HashMap<>();
        List<InstaDomain> instaDomains = getInstaImgAndDesc();

        model.addAttribute("insta", instaDomains);

        System.out.println("instaDomains.size = " + instaDomains.size());
        System.out.println("instaDomains = \n" + instaDomains);
//        System.out.println("map = \n" + map);

        return "home";
    }

    @GetMapping("/test2")
    @ResponseBody
    String home() {
        return "Happy Coding!";
    }


}


