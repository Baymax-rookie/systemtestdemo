package org.systemtest.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.systemtest.demo.entity.Patient;

import java.util.List;

/**
 * @author 12589
 */
@Mapper
@Component
public interface PatientMapper {
    @Select("SELECT * FROM patient")
    List<Patient> getAllPatient();

    @Select("SELECT sum(price) FROM drug WHERE id IN(SELECT drug_id FROM patient_drug WHERE patient_id =#{id})")
    double getDrugPriceByPatientId(Integer id);

    @Select("SELECT sum(price) FROM check_project WHERE id IN(SELECT project_id FROM patient_project WHERE patient_id =#{id})")
    double getProjectPriceByPatientId(Integer id);

    @Select("SELECT name FROM patient WHERE id_number =#{id}")
    String getPatientName(Integer id);

    @Select("SELECT * FROM patient WHERE id_number=#{id}")
    Patient getPatientById(Integer id);

    @Select("SELECT * FROM patient WHERE name=#{username}")
    Patient getPatientByName(String username);

    @Select("SELECT * FROM patient WHERE id_number IN (SELECT patient_id FROM user_patient WHERE user_id=#{id})")
    Patient getPatientByUserId(Integer id);
}
