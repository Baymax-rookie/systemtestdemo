package org.systemtest.demo.entity;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 12589
 */
@Data
public class Storage {
    private int id;
    private Integer code;
    private String name;
    private String  expireTime;
    private String unit;
    private Integer number;
    private double price;

    public Storage(Integer code,String name,String expireTime,String unit,Integer number,double price){
        this.code=code;
        this.name=name;
        this.expireTime=expireTime;
        this.unit=unit;
        this.number=number;
        this.price=price;
    }

    public static void main(String[] args) {
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dateStr=simpleDateFormat.format(date);
        System.out.println(dateStr);
    }
}
