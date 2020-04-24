package com.example.oauth.service.security;


import com.example.oauth.entity.User;
import com.example.oauth.repo.UserJpaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserJpaRepo userJpaRepo;
    private final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userJpaRepo.findByUid(name).orElseThrow(() -> new UsernameNotFoundException("user is not exists"));

        return user;
    }
}
