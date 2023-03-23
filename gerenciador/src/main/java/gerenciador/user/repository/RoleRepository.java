package gerenciador.user.repository;

import gerenciador.user.dao.Role;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RoleRepository extends ReactiveMongoRepository<Role, String> {

}
