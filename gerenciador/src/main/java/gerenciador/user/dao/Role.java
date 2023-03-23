package gerenciador.user.dao;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document(collection = "role")
public class Role {

    @MongoId
    String id;
    String role;

}
