package org.systemtest.demo.control;

import com.google.gson.Gson;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.systemtest.demo.entity.Storage;
import org.systemtest.demo.enums.ResponseEnum;
import org.systemtest.demo.service.StorageService;
import org.systemtest.demo.utils.ResultData;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 12589
 */
@RestController("/hjstorage")
public class StorageController {
    @Autowired
    StorageService storageService;

    Gson gson=new Gson();
    @GetMapping("/storages")
    public String getAllStorage(){
        List<Storage> list=storageService.getAllStorage();
        if (list!=null){
            return gson.toJson(new ResultData<>(ResponseEnum.INFORM_SUCCESS,list));
        }
        return gson.toJson(new ResultData<>(ResponseEnum.INFORM_FAIL));
    }

    @PostMapping("/addstorage")
    public String addStorage(@RequestBody Storage storage){
        Date date=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateTime=dateFormat.format(date);
        storage.setExpireTime(dateTime);
        boolean isInsert=storageService.isInserted(storage);
        if (isInsert){
            return gson.toJson(new ResultData<>(ResponseEnum.INSERT_SUCCESS));
        }
        return gson.toJson(new ResultData<>(ResponseEnum.OPERATION_FAIL));
    }

    @PostMapping("/addnumber")
    public String addNumber(Integer number,int id){
        boolean isAdd=storageService.isAddStorage(number,id);
        if (isAdd){
            return gson.toJson(new ResultData<>(ResponseEnum.ADD_SUCCESS));
        }
        return gson.toJson(new ResultData<>(ResponseEnum.OPERATION_FAIL));
    }

    @PostMapping("/decnumber")
    public String decNumber(Integer number,int id) {
        if (storageService.isSubStorage(number,id)){
            return gson.toJson(new ResultData<>(ResponseEnum.OPERATION_SUCCESS));
        }
        return gson.toJson(new ResultData<>(ResponseEnum.OPERATION_FAIL));
    }

    @Delete("/deletestorage")
    public String deleteStorage(int id){
        if (storageService.isDeleteStorage(id)){
            return gson.toJson(new ResultData<>(ResponseEnum.DELETE_SUCCESS));
        }
        return gson.toJson(new ResultData<>(ResponseEnum.OPERATION_FAIL));
    }

    @PostMapping("/updatenumber")
    public String updateStorage(Integer number){
        if (storageService.isUpdateStorage(number)){
            return gson.toJson(new ResultData<>(ResponseEnum.UPDATE_SUCCESS));
        }
        return gson.toJson(new ResultData<>(ResponseEnum.OPERATION_FAIL));
    }
}
