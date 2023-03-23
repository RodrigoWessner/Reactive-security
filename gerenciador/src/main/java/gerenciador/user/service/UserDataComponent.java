package gerenciador.user.service;

import gerenciador.user.dao.User;
import gerenciador.user.mapper.UserMapper;
import gerenciador.user.model.UserBO;
import gerenciador.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Component
@Slf4j
@RequiredArgsConstructor
public class UserDataComponent {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public Mono<UserBO> findUserById(final String id) {
        try {
            return Mono.just(id)
                    .doOnNext(l -> log.info("Finding user id: {}", id))
                    .flatMap(userRepository::findById)
                    .doOnSuccess(l -> log.info("User found: {}", l.toString()))
                    .doOnError(l -> log.error("Error on finding user id: {}", id))
                    .map(data -> userMapper.toBO(data));
        } catch (RuntimeException ex) {
            throw new RuntimeException(ex);
        }
    }

    public Mono saveUser(final User user) {
        try {
            return Mono.just(user)
                    .flatMap(userRepository::save)
                    .doOnSuccess(savedUser -> log.info("User {} saved!", savedUser))
                    .doOnError(error -> log.error("Error on save user." + error.getStackTrace()))
                    .map(data -> userMapper.toBO(data));
        } catch (RuntimeException ex) {
            throw new RuntimeException(ex);
        }
    }

    public Mono updateUser(final String id, final User user) {
        if (Objects.nonNull(findUserById(id))) {
            try {
                return Mono.just(user)
                        .flatMap(userRepository::save)
                        .doOnSuccess(updated -> log.info("User {} updated!", updated))
                        .doOnError(error -> log.error("Error on update user. {}", error.getStackTrace()))
                        .map(data -> userMapper.toBO(data));
            } catch (RuntimeException ex) {
                throw new RuntimeException(ex);
            }
        } else
            return Mono.empty();
    }

    public Mono deleteUser(final String id) {
        if (Objects.nonNull(findUserById(id))) {
            try {
                return Mono.just(id)
                        .flatMap(userRepository::deleteById)
                        .doOnSuccess(savedUser -> log.info("User {} deleted!", savedUser))
                        .doOnError(error -> log.error("Error on delete user. {}", error.getStackTrace()));
            } catch (RuntimeException ex) {
                throw new RuntimeException(ex);
            }
        } else
            return Mono.empty();
    }
}
