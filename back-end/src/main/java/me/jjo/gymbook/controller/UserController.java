package me.jjo.gymbook.controller;

import me.jjo.gymbook.dto.TokenDTO;
import me.jjo.gymbook.dto.UserLoginDTO;
import me.jjo.gymbook.dto.UserSignUpDTO;
import me.jjo.gymbook.jwt.JwtFilter;
import me.jjo.gymbook.jwt.TokenProvider;
import me.jjo.gymbook.service.CustomUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/user")
public class UserController {
    private final TokenProvider tokenProvider;
    private final CustomUserDetailsService customUserDetailsService;
    private final AuthenticationManager authenticationManager;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserController(TokenProvider tokenProvider,
                          CustomUserDetailsService customUserDetailsService,
                          AuthenticationManager authenticationManager){
        this.tokenProvider = tokenProvider;
        this.customUserDetailsService = customUserDetailsService;

        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserSignUpDTO> signUp(@Valid @RequestBody UserSignUpDTO userSignUpDto) {
        UserSignUpDTO userDto = customUserDetailsService.signUp(userSignUpDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{phone}")
                .buildAndExpand(userDto.getPhone())
                .toUri();
        return ResponseEntity
                .created(location)
                .body(userDto);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@Valid @RequestBody UserLoginDTO userLoginDto) {
        logger.debug("user Info : {}",userLoginDto.toString());
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userLoginDto.getPhone(), userLoginDto.getPassword());

        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.createToken(authentication);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);

        return ResponseEntity.ok()
                .headers(httpHeaders)
                .body(TokenDTO
                        .builder()
                        .token(jwt)
                        .build());
    }
}
