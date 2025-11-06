package br.com.diegopimenta.mapper;
import static br.com.diegopimenta.mapper.ObjectMapper.parseListObjects;
import static br.com.diegopimenta.mapper.ObjectMapper.parseObject;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import br.com.diegopimenta.dto.UserDTO;
import br.com.diegopimenta.mock.MockUser;
import br.com.diegopimenta.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ObjectMapperTests {
    MockUser inputObject;

    @BeforeEach
    public void setUp() {
        inputObject = new MockUser();
    }

    @Test
    public void parseEntityToDTOTest() {
        UserDTO output = parseObject(inputObject.mockEntity(), UserDTO.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("Name Test0", output.getName());
        assertEquals("Email Test0", output.getEmail());
        assertEquals("Male", output.getGender());
    }

    @Test
    public void parseEntityListToDTOListTest() {
        List<UserDTO> outputList = parseListObjects(inputObject.mockEntityList(), UserDTO.class);
        UserDTO outputZero = outputList.get(0);

        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("Name Test0", outputZero.getName());
        assertEquals("Email Test0", outputZero.getEmail());
        assertEquals("Male", outputZero.getGender());

        UserDTO outputSeven = outputList.get(7);

        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("Name Test7", outputSeven.getName());
        assertEquals("Email Test7", outputSeven.getEmail());
        assertEquals("Female", outputSeven.getGender());

        UserDTO outputTwelve = outputList.get(12);

        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("Name Test12", outputTwelve.getName());
        assertEquals("Email Test12", outputTwelve.getEmail());
        assertEquals("Male", outputTwelve.getGender());
    }

    @Test
    public void parseDTOToEntityTest() {
        User output = parseObject(inputObject.mockDTO(), User.class);
        assertEquals(Long.valueOf(0L), output.getId());
        assertEquals("Name Test0", output.getName());
        assertEquals("Email Test0", output.getEmail());
        assertEquals("Male", output.getGender());
    }

    @Test
    public void parserDTOListToEntityListTest() {
        List<User> outputList = parseListObjects(inputObject.mockDTOList(), User.class);
        User outputZero = outputList.get(0);

        assertEquals(Long.valueOf(0L), outputZero.getId());
        assertEquals("Name Test0", outputZero.getName());
        assertEquals("Email Test0", outputZero.getEmail());
        assertEquals("Male", outputZero.getGender());

        User outputSeven = outputList.get(7);

        assertEquals(Long.valueOf(7L), outputSeven.getId());
        assertEquals("Name Test7", outputSeven.getName());
        assertEquals("Email Test7", outputSeven.getEmail());
        assertEquals("Female", outputSeven.getGender());

        User outputTwelve = outputList.get(12);

        assertEquals(Long.valueOf(12L), outputTwelve.getId());
        assertEquals("Name Test12", outputTwelve.getName());
        assertEquals("Email Test12", outputTwelve.getEmail());
        assertEquals("Male", outputTwelve.getGender());
    }
}