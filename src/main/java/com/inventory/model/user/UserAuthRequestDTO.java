package com.inventory.model.user;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserAuthRequestDTO {
    private String username;
    private String password;
}
