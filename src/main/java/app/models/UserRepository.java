package app.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Long> {
	
	public User findByEmail(String email);
	
	public User findByUsername(String username);

}
