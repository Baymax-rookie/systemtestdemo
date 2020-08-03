package org.systemtest.demo.control;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.systemtest.demo.entity.Drugs;
import org.systemtest.demo.enums.ResponseEnum;
import org.systemtest.demo.service.DrugService;
import org.systemtest.demo.utils.ResultData;

import java.util.List;

/**
 * @author 12589
 */
@RestController("/drugs")
public class DrugsController {

    @Autowired
    DrugService drugService;

    Gson gson=new Gson();

    @GetMapping("/alldrugs")
    public String getDrugs(){
        List<Drugs> allDrugs=drugService.getDrugs();
        if (allDrugs!=null){
            return gson.toJson(new ResultData<>(ResponseEnum.INFORM_FAIL));
        }
        return gson.toJson(new ResultData<>(ResponseEnum.INFORM_SUCCESS,allDrugs));
    }

    @GetMapping("/drugid")
    public String getDrugsByid(int id){
        Drugs drugs=drugService.getDrugById(id);
        if (drugs==null){
            return gson.toJson(new ResultData<>(ResponseEnum.INFORM_FAIL));
        }
        return gson.toJson(new ResultData<>(ResponseEnum.INFORM_SUCCESS,drugs));
    }

    @GetMapping("/patientid")
    public String getDrugByPid(Integer id){
        List<Drugs> drugs=drugService.getDrugsByPatientId(id);
        if (drugs==null){
            return gson.toJson(new ResultData<>(ResponseEnum.OPERATION_FAIL));
        }

        return gson.toJson(new ResultData<>(ResponseEnum.OPERATION_SUCCESS,drugs));
    }

    @GetMapping("/patientname")
    public String getDrugByPname(String name){
        List<Drugs> drugs=drugService.getDrugsByPatientName(name);
        if (drugs==null){
            return gson.toJson(new ResultData<>(ResponseEnum.OPERATION_FAIL));
        }

        return gson.toJson(new ResultData<>(ResponseEnum.OPERATION_SUCCESS,drugs));
    }

    @GetMapping("/drugname")
    public String getDrugByName(String name){
        Drugs drugs=drugService.getDrugsByName(name);
        if (drugs==null){
            return gson.toJson(new ResultData<>(ResponseEnum.OPERATION_FAIL));
        }
        return gson.toJson(new ResultData<>(ResponseEnum.OPERATION_SUCCESS,drugs));
    }

}
