package com.personal.personalapi.dto;

import com.personal.personalapi.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserResponseDTO {
    private Long id;
    private String nome;
    private String email;
    private Role role;
}
