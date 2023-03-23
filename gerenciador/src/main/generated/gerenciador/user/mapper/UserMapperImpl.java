package gerenciador.user.mapper;

import gerenciador.user.dao.User;
import gerenciador.user.dto.UserDTO;
import gerenciador.user.model.UserBO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-23T16:48:23-0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toBO(UserBO userBO) {
        if ( userBO == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( userBO.getId() );
        userDTO.setName( userBO.getName() );
        userDTO.setUserName( userBO.getUserName() );
        userDTO.setCpf( userBO.getCpf() );
        userDTO.setEnabled( userBO.isEnabled() );

        return userDTO;
    }

    @Override
    public UserDTO toDTO(UserBO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        UserDTO userDTO1 = new UserDTO();

        userDTO1.setId( userDTO.getId() );
        userDTO1.setName( userDTO.getName() );
        userDTO1.setUserName( userDTO.getUserName() );
        userDTO1.setCpf( userDTO.getCpf() );
        userDTO1.setEnabled( userDTO.isEnabled() );

        return userDTO1;
    }

    @Override
    public UserBO toBO(User user) {
        if ( user == null ) {
            return null;
        }

        UserBO userBO = new UserBO();

        userBO.setId( user.getId() );
        userBO.setName( user.getName() );
        userBO.setUserName( user.getUserName() );
        userBO.setCpf( user.getCpf() );
        userBO.setEnabled( user.isEnabled() );

        return userBO;
    }

    @Override
    public User toBO(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDTO.getId() );
        user.setName( userDTO.getName() );
        user.setUserName( userDTO.getUserName() );
        user.setCpf( userDTO.getCpf() );
        user.setEnabled( userDTO.isEnabled() );

        return user;
    }
}
