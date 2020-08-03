package org.systemtest.demo.control;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.systemtest.demo.enums.ResponseEnum;
import org.systemtest.demo.service.ProjectService;
import org.systemtest.demo.utils.ResultData;

/**
 * @author 12589
 */
@RequestMapping("/hjproject")
@RestController
public class ProjectController {
    @Autowired
    ProjectService projectService;

    Gson gson=new Gson();

    @GetMapping("/projects")
    public String getAllProjects(){
        return gson.toJson(new ResultData<>(ResponseEnum.INFORM_SUCCESS,projectService.getAllProject()));
    }

    
}
