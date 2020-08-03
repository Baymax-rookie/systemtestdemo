package org.systemtest.demo.service.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.systemtest.demo.entity.Patient;
import org.systemtest.demo.mapper.PatientMapper;
import org.systemtest.demo.service.PatientService;

import java.util.List;

/**
 * @author 12589
 */
@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    PatientMapper mapper;

    @Override
    public List<Patient> getAllPatients() {
        return mapper.getAllPatient();
    }

    @Override
    public Patient getPatientById(Integer id) {
        return mapper.getPatientById(id);
    }

    @Override
    public Patient getPatientByName(String username) {
        return mapper.getPatientByName(username);
    }

    @Override
    public Patient getPatientByUserId(Integer id) {
        return mapper.getPatientByUserId(id);
    }

    @Override
    public double getDrugPrice(Integer id) {
        return mapper.getDrugPriceByPatientId(id);
    }

    @Override
    public double getProjectPrice(Integer id) {
        return mapper.getProjectPriceByPatientId(id);
    }

    @Override
    public String getPatientName(Integer id) {
        return mapper.getPatientName(id);
    }
}
