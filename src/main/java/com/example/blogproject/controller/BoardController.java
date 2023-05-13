package com.example.blogproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
    @GetMapping({"", "/"}) // 아무것도 안붙였을대랑 / 붙였을때 이동.
    public String index() {
        return "index";
    }
}
