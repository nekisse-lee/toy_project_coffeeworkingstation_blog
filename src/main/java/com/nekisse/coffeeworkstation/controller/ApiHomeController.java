package com.nekisse.coffeeworkstation.controller;


import com.nekisse.coffeeworkstation.domain.InstaDomain;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.nekisse.coffeeworkstation.utils.InstagramUtils.getInstaImgAndDesc;

@RestController()
@RequestMapping("/api")
public class ApiHomeController {



    @GetMapping("")
    public @ResponseBody String home3() throws IOException {
        Map<String, String> stringStringMap = new HashMap<>();
        List<InstaDomain> instaDomains = getInstaImgAndDesc();
        stringStringMap.put(instaDomains.get(0).getDesc(), instaDomains.get(0).getImgUrl());
        System.out.println("stringStringMap = " + stringStringMap);
        System.out.println("instaDomains.get(0).getUrlImage() = " + instaDomains.get(0).getImgUrl().toString());
        String replace = instaDomains.get(0).getImgUrl().replace("\"", "");

        return replace;
    }

    @GetMapping("/test2")
    @ResponseBody
    String home() {
        return "Happy Coding!";
    }


}


