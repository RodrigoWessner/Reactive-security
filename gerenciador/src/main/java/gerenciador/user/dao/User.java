package gerenciador.user.dao;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Set;

@Data
@Document(collection = "user")
public class User {

    @MongoId
    String id;
    String name;
    String userName;
    String cpf;
    boolean enabled;
    @DBRef
    Contact contact;
    @DBRef
    Address address;
    @DBRef
    Set<Role> roles;

}
