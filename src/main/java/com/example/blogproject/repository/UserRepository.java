package com.example.blogproject.repository;

import com.example.blogproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// User 객체를 관리하는 Repository, pk 는 Integer
// @Repository 생략 가능하다. 자동으로 Bean 으로 등록된다.
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}


// JPA Naming 쿼리 전략
// SELECT * FROM user WHERE username = ? AND password = ?
//    User findByUsernameAndPassword(String username, String password);

//    @Query(value = "SELECT * FROM user WHERE username = ? AND password = ?", nativeQuery = true)
//    User login(String username, String password);