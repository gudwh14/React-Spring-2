package me.jjo.gymbook.service;

import me.jjo.gymbook.dto.UserSignUpDto;
import me.jjo.gymbook.entity.Authority;
import me.jjo.gymbook.entity.User;
import me.jjo.gymbook.repository.UserJpaRepository;
import me.jjo.gymbook.userDetails.CustomUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserJpaRepository userJpaRepository;
    private final PasswordEncoder passwordEncoder;
    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    public CustomUserDetailsService(UserJpaRepository userJpaRepository,
                                    PasswordEncoder passwordEncoder) {
        this.userJpaRepository = userJpaRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String phone) throws UsernameNotFoundException{
        logger.debug("loadUserByUsername : {}", phone);

        return userJpaRepository.findOneWithAuthoritiesByPhone(phone)
                .map(user -> new CustomUserDetails(user))
                .orElseThrow(() -> new UsernameNotFoundException(phone + " -> 데이터베이스에서 찾을 수 없습니다."));
    }

    @Transactional
    public UserSignUpDto signUp(UserSignUpDto userSignUpDto) {
        Authority authority = Authority.builder()
                .authorityName("ROLE_USER")
                .build();

        User user = User.builder()
                .name(userSignUpDto.getName())
                .password(passwordEncoder.encode(userSignUpDto.getPassword()))
                .phone(userSignUpDto.getPhone())
                .authorities(Collections.singleton(authority))
                .build();
        userJpaRepository.save(user);
        return userSignUpDto;
    }
}
