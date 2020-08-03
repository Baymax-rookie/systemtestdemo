package org.systemtest.demo.control;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.systemtest.demo.entity.SysUser;
import org.systemtest.demo.enums.ResponseEnum;
import org.systemtest.demo.service.UserService;
import org.systemtest.demo.utils.ResultData;

/**
 * @author 12589
 */
@RestController("/hjuser")
public class UserController {
    @Autowired
    UserService userService;
    Gson gson=new Gson();

    @GetMapping("/getuserid")
    public String getUserById(Integer id){
        SysUser user=userService.getUserById(id);
        if (user!=null){
            return gson.toJson(new ResultData<>(ResponseEnum.OPERATION_SUCCESS,user));
        }
        return gson.toJson(new ResultData<>(ResponseEnum.INFORM_FAIL));
    }

    @GetMapping("/getusername")
    public String getUserbyName(String name){
        SysUser user=userService.getUserByUsername(name);
        if (user!=null){
            return gson.toJson(new ResultData<>(ResponseEnum.OPERATION_SUCCESS,user));
        }
        return gson.toJson(new ResultData<>(ResponseEnum.INFORM_FAIL));
    }
}
