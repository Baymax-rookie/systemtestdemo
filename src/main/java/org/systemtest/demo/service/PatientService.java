package org.systemtest.demo.service;

import org.systemtest.demo.entity.Patient;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author 12589
 */
public interface PatientService {
    public List<Patient> getAllPatients();

    public Patient getPatientById(Integer id);

    public Patient getPatientByName(String username);

    public Patient getPatientByUserId(Integer id);

    public double getDrugPrice(Integer id);

    public double getProjectPrice(Integer id);

    public String getPatientName(Integer id);


}
