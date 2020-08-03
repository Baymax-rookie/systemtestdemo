package org.systemtest.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.systemtest.demo.entity.Drugs;

import java.util.List;

/**
 * @author 12589
 */
@Mapper
@Component
public interface DrugMapper {
    /**
     * 得到所有药品信息
     * @return List<Drug>
     * */
    @Select("SELECT * FROM drug")
    List<Drugs> getAllDrugs();

    @Select("SELECT name FROM drug WHERE id=#{id}")
    String getDrugNameFromId(int id);

    @Select("SELECT * FROM drug WHERE name=#{name}")
    Drugs getDrugByName(String name);

    @Select("SELECT * FROM drug WHERE id=#{id}")
    Drugs getDrugById(int id);

    @Select("SELECT * FROM drug WHERE id IN (SELECT drug_id FROM patient_drug WHERE patient_id=(SELECT patient_id FROM patient WHERE name=#{name}))")
    List<Drugs> getDrugsByPatientName(String name);

    @Select("SELECT * FROM drug WHERE id IN (SELECT drug_id FROM patient_drug WHERE patient_id=#{id}")
    List<Drugs> getDrugsByPatientId(Integer id);

}

