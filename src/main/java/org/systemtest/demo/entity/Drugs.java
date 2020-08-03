package org.systemtest.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 12589
 */
@Data
@AllArgsConstructor
public class Drugs implements Serializable {

    private static final long SERIALIZED_ID =1L;
    private int id;
    private Integer code;
    private String name;
    private String specification;
    private String unit;
    private int number;
    private double price;
    private String user_method;
}
