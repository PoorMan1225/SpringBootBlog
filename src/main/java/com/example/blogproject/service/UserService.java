package com.example.blogproject.service;

import com.example.blogproject.model.User;
import com.example.blogproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// 스프링이 컴포넌트 스캔을 통해서 Bean 에 등록을 해줌 IoC 를 해준다.
// 서비스는 하나의 트랜잭션 (작업을 수행하기 위한 작은 단위)
// 을 관리하기 위해 필요한 클래스 이며 어떤 비즈니스 모델의 하나의 작업을 수행하는 클래스 라고 보면된다.
// 여기서 비즈니스 모델은 여러가지 트랜잭션이 모이는 작업이 될 수 있다.
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    private final BCryptPasswordEncoder encoder;


    @Transactional
    public void 회원가입(User user) {
        String rawPassword = user.getPassword();
        String encPassword = encoder.encode(rawPassword);
        user.setPassword(encPassword);
        userRepository.save(user);
    }

//    @Transactional(readOnly = true) // Select 할때 트랜잭션 시작, 서비스 종료시에 트랜잭션 종료(정합성)
//    public User 로그인(User user) {
//        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
//    }
}
