package com.example.project2.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.*;

@AllArgsConstructor @Data
public class User {
    @NotEmpty(message = "id is required")
    @Size(min = 3 , max = 3)
    private String id;
    @NotEmpty(message = "username is required")
    @Size(min = 5 , max = 5)
    private String username;
    @NotEmpty(message = "password is required")
    @Pattern(regexp ="  ^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{6}$\n")

    private String password ;
    @NotEmpty(message ="email is required")
    @Email(message = "email should be valid!!")
    private String email;
    @NotEmpty(message ="role is required")
    @Pattern(regexp ="(Admin | Customer)")
    private String role ;
    @NotNull(message = "should enter a balance ")
    @Positive(message = "balance should be positive number")
    private Integer balance ;
}
