package gerenciador.user.model;

import lombok.Data;

import java.util.List;

@Data
public class UserBO {

    String id;
    String name;
    String userName;
    String cpf;
    boolean enabled;
    ContactBO contactBO;
    AddressBO addressBO;
    List<RoleBO> rolesBO;

}
