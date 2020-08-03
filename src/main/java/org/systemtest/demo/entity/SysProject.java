package org.systemtest.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 12589
 */
@Data
@AllArgsConstructor
public class SysProject implements Serializable {
    private static final long SERIALIZED_ID =1L;
    private Integer id;
    private String name;
    private double price;
    private String department;
    private String unit;
    private int total;
    private String advice;
    private String specificaitons;

}
