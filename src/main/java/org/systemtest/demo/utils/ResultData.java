package org.systemtest.demo.utils;

import lombok.Data;
import org.systemtest.demo.enums.ResponseEnum;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author 12589
 */
@Data
public class ResultData<T> {
    private int code;
    private String message;
    private T data;
    public ResultData(int code,T data){
        this.code=code;
        this.data=data;
        this.message=null;
    }
    public ResultData(int code,String message,T data){
        this.code=code;
        this.message=message;
        this.data=data;
    }
    public ResultData(T data){
        this.data=data;
    }
    public ResultData(ResponseEnum responseEnum,T data){
        this.code=responseEnum.getCode();
        this.message=responseEnum.getMessage();
        this.data=data;
    }
    public ResultData(ResponseEnum responseEnum){
        this.code=responseEnum.getCode();
        this.message=responseEnum.getMessage();
    }

}
