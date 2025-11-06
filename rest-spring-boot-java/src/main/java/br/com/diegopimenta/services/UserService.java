package br.com.diegopimenta.services;

import br.com.diegopimenta.dto.UserDTO;
import static br.com.diegopimenta.mapper.ObjectMapper.parseObject;
import static br.com.diegopimenta.mapper.ObjectMapper.parseListObjects;

import br.com.diegopimenta.dto.UserDtoV2;
import br.com.diegopimenta.mapper.CustomMapper;
import br.com.diegopimenta.model.User;
import br.com.diegopimenta.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CustomMapper customMapper;
    private Logger logger = Logger.getLogger(UserService.class.getName());

    public UserDTO getUserById(Long id) {
        logger.info("Fetching user with id: " + id);
        User entity = userRepository.findById(id).orElse(null);
        return parseObject(entity, UserDTO.class);
    }

    public List<UserDTO> getUsers() {
        logger.info("User list requested");

        return parseListObjects(userRepository.findAll(), UserDTO.class);
    }

    public List<UserDtoV2> getUsersV2() {
        logger.info("User list requested");

        var users = userRepository.findAll();
        return users.stream()
                .map(customMapper::entityToDTO)
                .toList();
    }

    public void createUser(UserDTO user) {
        logger.info("Creating user: " + user.getName());

        var entity = parseObject(user, User.class);
        userRepository.save(entity);
    }

    public void createUserV2(UserDtoV2 user) {
        logger.info("Creating user V2: " + user.getName());

        var entity = customMapper.dtoToEntity(user);
        userRepository.save(entity);
    }
}
