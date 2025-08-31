package com.inventory.model.user;

import com.inventory.model.enums.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserCreateDTO {
    private Long id;
    private String username;
    private String password;
    private Role role;
}
