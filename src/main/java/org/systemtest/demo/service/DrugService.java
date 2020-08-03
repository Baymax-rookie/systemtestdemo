package org.systemtest.demo.service;

import org.systemtest.demo.entity.Drugs;

import java.util.List;

/**
 * @author 12589
 */
public interface DrugService {
    public List<Drugs> getDrugs();

    public Drugs getDrugById(int id);

    public Drugs getDrugsByName(String name);

    public List<Drugs> getDrugsByPatientName(String patientName);

    public List<Drugs> getDrugsByPatientId(Integer id);
}
