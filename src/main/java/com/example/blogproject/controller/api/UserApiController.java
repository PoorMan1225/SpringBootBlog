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

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    @PostMapping("/api/user")
    public ResponseDto<Integer> save(@RequestBody User user) {
        user.setRole(RoleType.USER);
        userService.회원가입(user);
        System.out.println("UserApiController : save 호출됨");
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
}
