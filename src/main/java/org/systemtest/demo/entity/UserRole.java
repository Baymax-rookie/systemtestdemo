package org.systemtest.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 12589
 */
@AllArgsConstructor
@Data
public class UserRole {
    private String username;
    private String password;
    private String roles;
    private String permission;
}
