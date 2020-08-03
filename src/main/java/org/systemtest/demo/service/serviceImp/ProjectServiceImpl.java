package org.systemtest.demo.service.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.systemtest.demo.entity.SysProject;
import org.systemtest.demo.mapper.ProjectMapper;
import org.systemtest.demo.service.ProjectService;

import java.util.List;

/**
 * @author 12589
 */
@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectMapper projectMapper;


    @Override
    public List<SysProject> getAllProject() {
        return projectMapper.getAllProject();
    }

    @Override
    public SysProject getProjectById(Integer id) {
        return projectMapper.getProjectById(id);
    }

    @Override
    public SysProject getProjectByName(String name) {
        return projectMapper.getProjectByName(name);
    }

    @Override
    public String getSpecificationByDepartment(String departName) {
        return projectMapper.getSpecificationByDepartment(departName);
    }

    @Override
    public String getSpecificationByName(String name) {
        return projectMapper.getSpecificationByName(name);
    }

    @Override
    public List<SysProject> getProjectByPatient(Integer id) {
        return projectMapper.getProjectFromPatientId(id);
    }
}
