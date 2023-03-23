package gerenciador.user.dao;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document(collection = "contact")
public class Contact {

    @MongoId
    String id;
    String type;
    String description;

}
