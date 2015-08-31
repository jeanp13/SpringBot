package app.models;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface RoleRepository extends CrudRepository<Role, Long> {

	public Role findByName(String name);
	
}
