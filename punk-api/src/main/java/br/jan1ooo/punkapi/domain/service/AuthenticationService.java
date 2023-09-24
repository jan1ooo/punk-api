package br.jan1ooo.punkapi.domain.service;

import br.jan1ooo.punkapi.domain.dto.AuthenticationDTO;
import br.jan1ooo.punkapi.domain.exeption.BussinesException;
import br.jan1ooo.punkapi.domain.model.user.LoginResponseDTO;
import br.jan1ooo.punkapi.domain.model.user.User;
import br.jan1ooo.punkapi.domain.repository.UserRepository;
import br.jan1ooo.punkapi.infra.security.TokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthenticationService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    public LoginResponseDTO login(@Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var auth = authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((User)auth.getPrincipal());
        log.warn("Usuario " + data.username() + " realizou um login");
        return new LoginResponseDTO(token);
    }

    public String register(@Valid AuthenticationDTO data){
        if(this.userRepository.findByUsername(data.username()) != null){
            throw new BussinesException("Já existe um usuario cadastrado com esse username");
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.username(), encryptedPassword);
        this.userRepository.save(newUser);
        log.warn("Novo usuario registrado com username " + data.username());
        return "Usuario cadastrado com Sucesso";
    }
}
