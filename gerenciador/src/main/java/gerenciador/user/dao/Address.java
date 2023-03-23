package gerenciador.user.dao;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document(collection = "address")
public class Address {

    @MongoId
    String id;
    String address;

}
