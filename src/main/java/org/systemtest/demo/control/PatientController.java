package org.systemtest.demo.control;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.systemtest.demo.enums.ResponseEnum;
import org.systemtest.demo.service.PatientService;
import org.systemtest.demo.utils.ResultData;

/**
 * @author 12589
 */
@RequestMapping("hjpatient")
@RestController()
public class PatientController {
    @Autowired
    PatientService patientService;

    Gson gson=new Gson();

    @GetMapping("/allpatient")
    public String getAllPatient(){
        return gson.toJson(new ResultData<>(ResponseEnum.WAITING_CHECK,patientService.getAllPatients()));
    }

    @GetMapping("/patientid")
    public String getPatientById(Integer id){
        return gson.toJson(new ResultData<>(patientService.getPatientById(id)));
    }

    @GetMapping("/patientname")
    public String getPatientByName(String name){
        return gson.toJson(new ResultData<>(patientService.getPatientByName(name)));
    }

    @GetMapping("/userid")
    public String getPatientByUser(Integer id){
        return gson.toJson(new ResultData<>(patientService.getPatientByUserId(id)));
    }

    @GetMapping("/querydrugprice")
    public String getDrugPrice(Integer id){
        double price=patientService.getDrugPrice(id);
        return gson.toJson(new ResultData<>(ResponseEnum.QUERY_SUCCESS,price));
    }

    @GetMapping("/queryprojectprice")
    public String getProjectPrice(Integer id){
        double price=patientService.getProjectPrice(id);
        return gson.toJson(new ResultData<>(ResponseEnum.QUERY_SUCCESS,price));
    }

    @GetMapping("/getpatientname")
    public String getPatientName(Integer id){
        String name=patientService.getPatientName(id);
        return gson.toJson(new ResultData<>(ResponseEnum.OPERATION_SUCCESS,name));
    }
}
