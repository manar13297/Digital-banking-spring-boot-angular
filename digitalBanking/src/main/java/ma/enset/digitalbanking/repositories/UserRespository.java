package ma.enset.digitalbanking.repositories;

import ma.enset.digitalbanking.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespository extends JpaRepository<User,String> {
}
