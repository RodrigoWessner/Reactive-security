package gerenciador.user.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {

    String id;
    String name;
    String userName;
    String cpf;
    boolean enabled;
    ContactDTO contactDTO;
    AddressDTO addressDTO;
    List<RoleDTO> rolesDTO;

}
