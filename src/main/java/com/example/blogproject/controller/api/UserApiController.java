package com.example.blogproject.controller.api;

import com.example.blogproject.dto.ResponseDto;
import com.example.blogproject.model.RoleType;
import com.example.blogproject.model.User;
import com.example.blogproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    // 맴버 변수로 di 를 할 수도 있다. 변수로 하는것이 낫다. 함수의 매개변수 보다는.
    private final HttpSession httpSession;

    @PostMapping("/api/user")
    public ResponseDto<Integer> save(@RequestBody User user) {
        user.setRole(RoleType.USER);
        userService.회원가입(user);
        System.out.println("UserApiController : save 호출됨");
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    // 전통적 세션 방식의 로그인.
    @PostMapping("/api/user/login")
    public ResponseDto<Integer> login(@RequestBody User user){//, HttpSession session) { // 여기서 함수의 매개변수로 DI 를 할 수 도 있고.
        System.out.println("UserApiController : login 호출됨");
        User principal = userService.로그인(user);
        if(principal != null) {
            httpSession.setAttribute("principal", principal);
        }
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    // 스프링 시큐리티를 통한 로그인 방식.

}
