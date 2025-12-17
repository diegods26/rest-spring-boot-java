package br.com.diegopimenta.services;

import br.com.diegopimenta.mapper.CustomMapper;
import br.com.diegopimenta.mock.MockUser;
import br.com.diegopimenta.model.User;
import br.com.diegopimenta.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    MockUser input;

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Spy
    private CustomMapper customMapper;

    @BeforeEach
    void setUp() {
        input = new MockUser();
    }

    @Test
    void getUserById() {
        User entity = input.mockEntity(1);
        when(userRepository.findById(1L)).thenReturn(Optional.of(entity));

        var result = userService.getUserById(1L);
        assertNotNull(result);
        assertNotNull(result.getId());
        assertEquals(1L, result.getId());
        assertEquals("Name Test1", result.getName());
        assertEquals("Female", result.getGender());
        assertEquals("Email Test1", result.getEmail());

//        result.getLinks()
//                .stream()
//                .anyMatch(link -> link.getRel().value().equals("self")
//                        && link.getHref().endsWith("/api/users/1")
//                        && link.getType().equals("GET"));
    }

    @Test
    void getUsers() {
        List<User> entities = input.mockEntityList();
        when(userRepository.findAll()).thenReturn(entities);

        var result = userService.getUsers();
        assertNotNull(result);
        assertEquals(14, result.size());

        var user = result.get(1);
        assertNotNull(user);
        assertNotNull(user.getId());
        assertEquals(1L, user.getId());
        assertEquals("Name Test1", user.getName());
        assertEquals("Female", user.getGender());
        assertEquals("Email Test1", user.getEmail());

//        assertTrue(
//                user.getLinks()
//                        .stream()
//                        .anyMatch(link -> link.getRel().value().equals("self")
//                                && link.getHref().endsWith("/api/users/1")
//                                && link.getType().equals("GET")));
    }

    @Test
    void createUser() {
        var dto = input.mockDTO(1);
        var entity = input.mockEntity(1);
        when(userRepository.save(any(User.class))).thenReturn(entity);

        userService.createUser(dto);

        verify(userRepository, times(1)).save(any(User.class));
        verify(customMapper, times(1)).dtoToEntity(dto);
    }

    @Test
    void createUserV2() {
        var dtoV2 = input.mockDTOV2(1);
        var entity = input.mockEntity(1);
        when(userRepository.save(any(User.class))).thenReturn(entity);

        userService.createUserV2(dtoV2);

        verify(userRepository, atLeastOnce()).save(any(User.class));
        verify(customMapper, times(1)).dtoToEntity(dtoV2);
    }

    @Test
    void getUsersV2() {
        List<User> entities = input.mockEntityList();
        when(userRepository.findAll()).thenReturn(entities);

        var result = userService.getUsersV2();
        assertNotNull(result);
        assertEquals(14, result.size());

        var user = result.get(1);
        assertNotNull(user);
        assertNotNull(user.getId());
        assertEquals(1L, user.getId());
        assertEquals("Name Test1", user.getName());
        assertEquals("Female", user.getGender());
        assertEquals("Email Test1", user.getEmail());
        assertNotNull(user.getBirthDate());
    }
}