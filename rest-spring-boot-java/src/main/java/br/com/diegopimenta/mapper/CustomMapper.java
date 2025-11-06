package br.com.diegopimenta.mapper;

import br.com.diegopimenta.dto.UserDtoV2;
import br.com.diegopimenta.model.User;
import org.springframework.stereotype.Service;

@Service
public class CustomMapper {

    public UserDtoV2 entityToDTO(User user) {
        UserDtoV2 dto = new UserDtoV2();

        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setGender(user.getGender());
        dto.setBirthDate(user.getBirthDate());
        return dto;
    }

    public User dtoToEntity(UserDtoV2 user) {
        User entity = new User();

        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setGender(user.getGender());
        entity.setBirthDate(user.getBirthDate());
        return entity;
    }
}
