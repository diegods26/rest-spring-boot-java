package br.com.diegopimenta.services;

import br.com.diegopimenta.controllers.UserController;
import br.com.diegopimenta.dto.UserDTO;
import br.com.diegopimenta.dto.UserDtoV2;
import br.com.diegopimenta.mapper.CustomMapper;
import br.com.diegopimenta.model.User;
import br.com.diegopimenta.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CustomMapper customMapper;
    private Logger logger = Logger.getLogger(UserService.class.getName());

    public UserDTO getUserById(Long id) {
        logger.info("Fetching user with id: " + id);
        User entity = userRepository.findById(id).orElse(null);
        if (entity == null) return null;

        var dto = customMapper.entityToDTO(entity);
        addHateoasLinks(dto);
        return dto;
    }

    private void addHateoasLinks(UserDTO dto) {
        dto.add(linkTo(methodOn(UserController.class).getUserById(dto.getId()))
                .withSelfRel()
                .withType("GET"));
    }

    public List<UserDTO> getUsers() {
        logger.info("User list requested");
        List<User> entities = userRepository.findAll();
        return entities.stream()
                .map(entity -> {
                    var dto = customMapper.entityToDTO(entity);
                    addHateoasLinks(dto);
                    return dto;
                })
                .toList();
    }

    public void createUser(UserDTO userDto) {
        logger.info("Creating user: " + userDto.getName());
        var entity = customMapper.dtoToEntity(userDto);
        userRepository.save(entity);
    }

    public void createUserV2(UserDtoV2 userDto) {
        logger.info("Creating user V2: " + userDto.getName());
        var entity = customMapper.dtoToEntity(userDto);
        userRepository.save(entity);
    }

    public List<UserDtoV2> getUsersV2() {
        logger.info("User list requested V2");
        var users = userRepository.findAll();
        return users.stream()
                .map(customMapper::entityToDTOV2)
                .toList();
    }
}
