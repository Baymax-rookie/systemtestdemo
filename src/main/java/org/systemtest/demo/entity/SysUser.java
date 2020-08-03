package org.systemtest.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 12589
 */
@Data
@AllArgsConstructor
public class SysUser  {
    private Integer id;
    private String name;
    private String password;
    private String salt;
    private String phone;

}
