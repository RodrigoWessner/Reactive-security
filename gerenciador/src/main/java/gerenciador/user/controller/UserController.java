package gerenciador.user.controller;

import gerenciador.user.dto.UserDTO;
import gerenciador.user.mapper.UserMapper;
import gerenciador.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {

    private final UserMapper userMapper;
    private final UserService userService;

    @GetMapping("/{id}")
    public Mono<UserDTO> getUserById(@PathVariable String id) {
        return Mono.just(id)
                .flatMap(userService::findUser)
                .map(user -> userMapper.toDTO(user));
    }

    @PostMapping
    public Mono<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        return Mono.just(userDTO)
                .flatMap(userService::saveUser)
                .map(user -> userMapper.toDTO(user));
    }

    @PutMapping
    public Mono<UserDTO> updateUser(@RequestBody UserDTO userDTO) {
        return Mono.just(userDTO)
                .flatMap(userService::updateUser)
                .map(user -> userMapper.toDTO(user));
    }

    @DeleteMapping("/{id}")
    public Mono deleteUser(@PathVariable String id) {
        return Mono.just(id)
                .flatMap(userService::deleteUser);
    }
}
