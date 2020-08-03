package org.systemtest.demo.service;

import org.systemtest.demo.entity.SysProject;

import java.util.List;

/**
 * @author 12589
 */
public interface ProjectService {

    public List<SysProject> getAllProject();

    public SysProject getProjectById(Integer id);

    public SysProject getProjectByName(String name);

    public String getSpecificationByDepartment(String departName);

    public String getSpecificationByName(String name);

    public List<SysProject>getProjectByPatient(Integer id);
}
