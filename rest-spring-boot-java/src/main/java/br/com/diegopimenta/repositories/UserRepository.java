package br.com.diegopimenta.repositories;

import br.com.diegopimenta.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
