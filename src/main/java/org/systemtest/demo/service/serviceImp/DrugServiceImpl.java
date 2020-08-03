package org.systemtest.demo.service.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.systemtest.demo.entity.Drugs;
import org.systemtest.demo.mapper.DrugMapper;
import org.systemtest.demo.service.DrugService;

import java.util.List;

/**
 * @author 12589
 */
@Service
public class DrugServiceImpl implements DrugService {

    @Autowired
    DrugMapper mapper;
    @Override
    public List<Drugs> getDrugs() {
        return mapper.getAllDrugs();
    }

    @Override
    public Drugs getDrugById(int id) {
        return mapper.getDrugById(id);
    }

    @Override
    public Drugs getDrugsByName(String name) {
        return mapper.getDrugByName(name);
    }

    @Override
    public List<Drugs> getDrugsByPatientName(String patientName) {
        return mapper.getDrugsByPatientName(patientName);
    }

    @Override
    public List<Drugs> getDrugsByPatientId(Integer id) {
        return mapper.getDrugsByPatientId(id);
    }
}
