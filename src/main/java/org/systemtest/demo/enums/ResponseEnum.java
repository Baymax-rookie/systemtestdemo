package org.systemtest.demo.enums;

import lombok.Data;

/**
 * @author 12589
 */


public enum ResponseEnum {
    /**
     * 数据插入成功
     * */
    WAITING_CHECK(1,"待就诊"),
    INSERT_SUCCESS(1,"数据插入成功"),
    OPERATION_SUCCESS(1,"操作成功"),
    INFORM_SUCCESS(1,"数据获取成功"),
    INSERT_FAIL(-1,"数据插入失败"),
    OPERATION_FAIL(-1,"操作失败"),
    INFORM_FAIL(-1,"数据获取失败"),
    QUERY_SUCCESS(1,"查询成功"),
    QUERY_FAIL(-1,"查询失败"),
    ADD_SUCCESS(1,"添加成功"),
    DELETE_SUCCESS(1,"删除成功"),
    UPDATE_SUCCESS(1,"更新成功"),
    UNKNOW_ERROR(-1,"未知错误");

    private int code;
    private String message;

    ResponseEnum(int code,String message){
        this.code=code;
        this.message=message;
    }

    public int getCode(){
        return code;
    }
    public String getMessage(){
        return message;
    }
}
