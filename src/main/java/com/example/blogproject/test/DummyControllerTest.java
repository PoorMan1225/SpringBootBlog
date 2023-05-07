package com.example.blogproject.test;

import com.example.blogproject.model.RoleType;
import com.example.blogproject.model.User;
import com.example.blogproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequiredArgsConstructor
public class DummyControllerTest {
    private final UserRepository userRepository;

    @PostMapping("/dummy/join")
    public String join(User user) {
        user.setRole(RoleType.USER);
        userRepository.save(user);
        return "회원가입이 완료되었습니다.";
    }

    @GetMapping("/dummy/user/{id}")
    public User detail(@PathVariable int id) {
        User user = userRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        return user;
    }

    @Transactional
    @PutMapping("/dummy/user/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User requestUser) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("수정에 실패하였습니다."));
        user.setPassword(requestUser.getPassword());
        user.setEmail(requestUser.getEmail());
        return user;
    }
}
