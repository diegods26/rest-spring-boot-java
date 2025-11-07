package br.com.diegopimenta.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@Data
public class UserDtoV2 {

    private Long id;
    private String name;
    private String email;
    private String gender;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date birthDate;
}
