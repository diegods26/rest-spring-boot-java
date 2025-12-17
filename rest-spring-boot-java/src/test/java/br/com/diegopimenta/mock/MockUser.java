package br.com.diegopimenta.mock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.diegopimenta.dto.UserDTO;
import br.com.diegopimenta.dto.UserDtoV2;
import br.com.diegopimenta.model.User;

public class MockUser {


    public User mockEntity() {
        return mockEntity(0);
    }
    
    public UserDTO mockDTO() {
        return mockDTO(0);
    }

    public UserDtoV2 mockDTOV2() {
        return mockDTOV2(0);
    }

    public List<User> mockEntityList() {
        List<User> persons = new ArrayList<User>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockEntity(i));
        }
        return persons;
    }

    public List<UserDTO> mockDTOList() {
        List<UserDTO> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockDTO(i));
        }
        return persons;
    }

    public List<UserDtoV2> mockDTOV2List() {
        List<UserDtoV2> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockDTOV2(i));
        }
        return persons;
    }

    public User mockEntity(Integer number) {
        User user = new User();
        user.setName("Name Test" + number);
        user.setGender(((number % 2)==0) ? "Male" : "Female");
        user.setId(number.longValue());
        user.setEmail("Email Test" + number);
        user.setBirthDate(new Date());
        return user;
    }

    public UserDTO mockDTO(Integer number) {
        UserDTO user = new UserDTO();
        user.setName("Name Test" + number);
        user.setGender(((number % 2)==0) ? "Male" : "Female");
        user.setId(number.longValue());
        user.setEmail("Email Test" + number);
        return user;
    }

    public UserDtoV2 mockDTOV2(Integer number) {
        UserDtoV2 user = new UserDtoV2();
        user.setName("Name Test" + number);
        user.setGender(((number % 2)==0) ? "Male" : "Female");
        user.setId(number.longValue());
        user.setEmail("Email Test" + number);
        user.setBirthDate(new Date());
        return user;
    }
}