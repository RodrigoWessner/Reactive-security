package gerenciador.user.service;

import gerenciador.user.dto.UserDTO;
import gerenciador.user.mapper.UserMapper;
import gerenciador.user.model.UserBO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    private final UserDataComponent userDataComponent;

    public Mono<UserBO> findUser(final String id) {
        return userDataComponent.findUserById(id);
    }

    public Mono<UserBO> saveUser(final UserDTO userDTO) {
        return userDataComponent.saveUser(userMapper.toBO(userDTO));
    }

    public Mono<UserBO> updateUser(final UserDTO userDTO) {
        return userDataComponent.updateUser(userDTO.getId(), userMapper.toBO(userDTO));
    }

    public Mono deleteUser(final String id) {
        return userDataComponent.deleteUser(id);
    }

}
