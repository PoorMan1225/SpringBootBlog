package com.example.blogproject.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// 사용자가 요청 -> 응답(HTML 파일)
// @Controller
// 사용자가 요청 -> 응답(Data)
@RestController
public class HttpControllerTest {

    @GetMapping("/http/get")
    public String getTest(Member m) {
        return "get: " + m.getId() +"," + m.getUserName();
    }
    @GetMapping("/http/get/{type}")
    public String getTest(@PathVariable String type) {
        return "get: " + type;
    }
    @PostMapping("/http/post")
    public String postTest(Member m) {
        return "post 요청" + m.toString();
    }
    @PutMapping("/http/put")
    public String putTest() {
        return "pussst 요청";
    }
    @DeleteMapping("/http/delete")
    public String deleteTest() {
        return "delete 요청";
    }
}
