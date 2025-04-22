package healthcarecenter.dao.impl;

import healthcarecenter.dao.CrudDAO;
import healthcarecenter.entity.Patient;

public class PatientDAOImpl implements CrudDAO<Patient> {
    @Override
    public boolean save(Patient entity) {
        return false;
    }

    @Override
    public boolean update(Patient entity) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public String generateNewId() {
        return "";
    }
}
