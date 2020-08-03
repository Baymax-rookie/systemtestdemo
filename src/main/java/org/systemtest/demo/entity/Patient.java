package org.systemtest.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 12589
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Patient implements Serializable {
    private static final long SERIALIZED_ID=1L;
    private Integer id;
    private String name;
    private int age;
    private String sex;
    private String dateBirth;
    private String resAddress;
    private String nation;
    private String bloodType;
    private String occupation;
}
