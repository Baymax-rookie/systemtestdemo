package org.systemtest.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.systemtest.demo.entity.SysProject;

import java.util.List;

/**
 * @author 12589
 */
@Mapper
@Component
public interface ProjectMapper {
    @Select("SELECT * FROM check_project")
    List<SysProject> getAllProject();

    @Select("SELECT * FROM check_project WHERE id=#{id}")
    SysProject getProjectById(Integer id);

    @Select("SELECT * FROM check_project WHERE name=#{name}")
    SysProject getProjectByName(String  name);

    @Select("SELECT specifications FROM check_project WHERE name=#{name}")
    String getSpecificationByName(String name);

    @Select("SELECT specifications FROM check_project WHERE department=#{department}")
    String getSpecificationByDepartment(String department);

    @Select("SELECT * FROM check_project WHERE id IN (SELECT project_id FROM patient_drug WHERE patient_id=#{id})")
    List<SysProject> getProjectFromPatientId(Integer id);
}