package gerenciador.user.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AddressBO {

    String id;
    String address;

}
