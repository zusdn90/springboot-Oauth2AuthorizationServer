package com.example.oauth.controller.user;

import com.example.oauth.entity.User;
import com.example.oauth.repo.UserJpaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1")
public class UserController {

    @Autowired
    private UserJpaRepo userJpaRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping(value = "/users")
    public List<User> findAll() {
        return userJpaRepo.findAll();
    }


    @PostMapping(value = "/users")
    public void insert() {
        userJpaRepo.save(User.builder()
                .msrl(1)
                .uid("gusdn90@gmail.com")
                .password(passwordEncoder.encode("1234"))
                .name("bbb")
                .roles(Collections.singletonList("ROLE_USER"))
                .build());
    }

}
