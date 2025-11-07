package br.com.diegopimenta.controllers;

import br.com.diegopimenta.dto.UserDTO;
import br.com.diegopimenta.dto.UserDtoV2;
import br.com.diegopimenta.model.User;
import br.com.diegopimenta.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<Object> createUser(@RequestBody UserDTO user) {
        userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created");
    }

    @PostMapping(value = "/v2",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<Object> createUserV2(@RequestBody UserDtoV2 user) {
        userService.createUserV2(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User V2 created");
    }
    @GetMapping(value = "/{id}",
            produces = { MediaType.APPLICATION_JSON_VALUE,
                         MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        UserDTO userDto = userService.getUserById(id);
        if (userDto != null) {
            return ResponseEntity.ok(userDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<UserDTO>> getUsers() {
        List<UserDTO> usersDto = userService.getUsers();
        return ResponseEntity.ok(usersDto);
    }

    @GetMapping(value = "/v2",
    produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<UserDtoV2>> getUsersV2() {
        List<UserDtoV2> usersDtoV2 = userService.getUsersV2();
        return ResponseEntity.ok(usersDtoV2);
    }
}
