package com.example.blogproject.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// 스프링이 com.example.blogproject 패키지 이하를 스캔해서 특정 어노테이션이 붙어 있는 클래스 파일들을 new 해서(Ioc) 스프링 컨테이너에 관리해준다.
@RestController
public class BlogControllerTest {

    @GetMapping("/test/hello")
    public String hello() {
        return "<h1>hello spring boot</h1>";
    }
}
