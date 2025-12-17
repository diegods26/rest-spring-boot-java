package br.com.diegopimenta.mapper;

import br.com.diegopimenta.dto.UserDTO;
import br.com.diegopimenta.dto.UserDtoV2;
import br.com.diegopimenta.model.User;
import org.springframework.stereotype.Service;

@Service
public class CustomMapper {

    public UserDTO entityToDTO(User user) {
        if (user == null) return null;

        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setGender(user.getGender());
        return dto;
    }

    public User dtoToEntity(UserDTO user) {
        if (user == null) return null;

        User entity = new User();
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setGender(user.getGender());
        return entity;
    }

    public UserDtoV2 entityToDTOV2(User user) {
        if (user == null) return null;

        UserDtoV2 dto = new UserDtoV2();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setGender(user.getGender());
        dto.setBirthDate(user.getBirthDate());
        return dto;
    }

    public User dtoToEntity(UserDtoV2 user) {
        if (user == null) return null;

        User entity = new User();
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setGender(user.getGender());
        entity.setBirthDate(user.getBirthDate());
        return entity;
    }
}
