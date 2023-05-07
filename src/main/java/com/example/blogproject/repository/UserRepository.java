package com.example.blogproject.repository;

import com.example.blogproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

// User 객체를 관리하는 Repository, pk 는 Integer
// @Repository 생략 가능하다. 자동으로 Bean 으로 등록된다.
public interface UserRepository extends JpaRepository<User, Integer> {

}
