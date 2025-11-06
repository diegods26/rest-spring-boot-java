package br.com.diegopimenta.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDtoV2 {

    private Long id;
    private String name;
    private String email;
    private String gender;
    private Date birthDate;
}
