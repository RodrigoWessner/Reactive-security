package gerenciador.user.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ContactBO {

    String id;
    String type;
    String description;

}
