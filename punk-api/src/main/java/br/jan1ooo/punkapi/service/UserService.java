package br.jan1ooo.punkapi.service;

import br.jan1ooo.punkapi.model.user.User;
import br.jan1ooo.punkapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public String create(User user){
        log.info("Criando novo usuario com username: " + user.getUsername());
        userRepository.save(user);
        return "Usario " + user.getUsername() + " Criado com sucesso";
    }

    public User findById(String id){
        log.info("Buscando um usuario com id: " + id);
        return userRepository.findById(id).get();
    }
}
