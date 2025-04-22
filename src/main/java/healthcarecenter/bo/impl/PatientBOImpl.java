package healthcarecenter.bo.impl;

import healthcarecenter.bo.PatientBO;
import healthcarecenter.dao.DAOFactory;
import healthcarecenter.dao.PatientDAO;
import healthcarecenter.dao.impl.PatientDAOImpl;
import healthcarecenter.dto.PatientDTO;

import java.util.ArrayList;

public class PatientBOImpl implements PatientBO {
    PatientDAOImpl patientDAO = (PatientDAOImpl) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.PATIENT);
    @Override
    public boolean save(PatientDTO patientDTO) {
        return false;
    }

    @Override
    public boolean update(PatientDTO patientDTO) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public String getNextId() {
        return "";
    }
}
