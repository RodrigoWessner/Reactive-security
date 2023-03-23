package gerenciador.user.mapper;

import gerenciador.user.dao.User;
import gerenciador.user.dto.UserDTO;
import gerenciador.user.model.UserBO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    //@Mapping(target = "contactBO", source = "contactDTO")
    //@Mapping(target = "addressBO", source = "addressDTO")
    //@Mapping(target = "rolesBO", source = "rolesDTO")
    UserDTO toBO(UserBO userBO);

//    @Mapping(target = "contactDTO", source = "contactBO")
//    @Mapping(target = "addressDTO", source = "addressBO")
//    @Mapping(target = "rolesDTO", source = "rolesBO")
    UserDTO toDTO(UserBO userDTO);

//    @Mapping(target = "contactDTO", source = "contact")
//    @Mapping(target = "addressDTO", source = "address")
//    @Mapping(target = "rolesDTO", source = "roles")
    UserBO toBO(User user);

    User toBO(UserDTO userDTO);
}
