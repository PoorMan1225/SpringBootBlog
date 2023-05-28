package com.example.blogproject.config.auth;

import com.example.blogproject.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class PrincipalDetail implements UserDetails {
    private User user; // 우리가 만든 User 정보를 꼭 담아야 한다.

    public PrincipalDetail(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collections = new ArrayList<>();
        collections.add((GrantedAuthority) () -> {
            // 꼭 ROLE 을 붙여줘야 한다. 안그러면 스프링 부트에서 인식을 못한다.
            return "ROLE_"+user.getRole();
        });
        return collections;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    // 계정이 만료되지 않았는지 리턴한다.
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    // 계정이 잠겨있지 않았는지 리턴한다.
    public boolean isAccountNonLocked() {
        return true;
    }


    @Override
    // 비밀번호가 만료되지 않았는지 리턴한다.
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
