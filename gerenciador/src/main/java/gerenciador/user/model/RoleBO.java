package gerenciador.user.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class RoleBO {

    String id;
    String role;

}
