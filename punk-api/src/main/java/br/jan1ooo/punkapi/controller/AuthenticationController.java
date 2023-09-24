package br.jan1ooo.punkapi.controller;

import br.jan1ooo.punkapi.domain.dto.AuthenticationDTO;
import br.jan1ooo.punkapi.domain.service.AuthenticationService;
import br.jan1ooo.punkapi.infra.security.TokenService;
import br.jan1ooo.punkapi.domain.model.user.LoginResponseDTO;
import br.jan1ooo.punkapi.domain.model.user.User;
import br.jan1ooo.punkapi.domain.repository.UserRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication", description = "API Authentication")
@RequiredArgsConstructor
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        return ResponseEntity.ok(authenticationService.login(data));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid AuthenticationDTO data){
        return ResponseEntity.ok(authenticationService.register(data));
    }

}
