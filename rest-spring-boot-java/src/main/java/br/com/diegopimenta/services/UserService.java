package br.com.diegopimenta.services;

import br.com.diegopimenta.model.User;
import br.com.diegopimenta.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private Logger logger = Logger.getLogger(UserService.class.getName());

    public User getUserById(Long id) {
        logger.info("Fetching user with id: " + id);
        return userRepository.findById(id).orElse(null);
    }

    public void createUser(User user) {
        logger.info("Creating user: " + user.getName());
        userRepository.save(user);
    }
}
