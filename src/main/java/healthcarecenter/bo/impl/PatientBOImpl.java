package healthcarecenter.bo.impl;

import healthcarecenter.bo.PatientBO;
import healthcarecenter.dao.DAOFactory;
import healthcarecenter.dao.PatientDAO;
import healthcarecenter.dto.PatientDTO;

import java.sql.SQLException;
import java.util.List;

public class PatientBOImpl implements PatientBO {
    PatientDAO patientDAO = (PatientDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.PATIENT);

    @Override
    public boolean savePatient(PatientDTO patientDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean updatePatient(PatientDTO patientDTO) throws SQLException,ClassNotFoundException{
        return false;
    }

    @Override
    public boolean deletePatient(String id) throws SQLException,ClassNotFoundException{
        return false;
    }

    @Override
    public String getNextPatientId() throws SQLException,ClassNotFoundException{
        return "";
    }

    @Override
    public List<PatientDTO> getAllPatient() throws SQLException,ClassNotFoundException {
        return List.of();
    }
}
