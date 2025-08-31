package com.inventory.model.user;

import com.inventory.model.enums.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserResponseDTO {
    private String username;
    private Role role;
}
