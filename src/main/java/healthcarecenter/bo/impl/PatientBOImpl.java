package healthcarecenter.bo.impl;

import healthcarecenter.bo.PatientBO;
import healthcarecenter.dao.DAOFactory;
import healthcarecenter.dao.PatientDAO;
import healthcarecenter.dto.PatientDTO;
import healthcarecenter.entity.Patient;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientBOImpl implements PatientBO {
    PatientDAO patientDAO = (PatientDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.PATIENT);

    @Override
    public boolean save(PatientDTO patientDTO) throws SQLException, ClassNotFoundException {
        return patientDAO.save(new Patient(
                patientDTO.getPatientId(),
                patientDTO.getName(),
                patientDTO.getAddress(),
                patientDTO.getGender(),
                patientDTO.getBirth(),
                patientDTO.getPhone(),
                patientDTO.getRegistrationDate()
        ));
    }

    @Override
    public boolean update(PatientDTO patientDTO) throws SQLException, ClassNotFoundException {
        return patientDAO.update(new Patient(
                patientDTO.getPatientId(),
                patientDTO.getName(),
                patientDTO.getAddress(),
                patientDTO.getGender(),
                patientDTO.getBirth(),
                patientDTO.getPhone(),
                patientDTO.getRegistrationDate()
        ));
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return patientDAO.delete(id);
    }

    @Override
    public String getNextPatientId() throws SQLException, ClassNotFoundException {
        return patientDAO.generateNewId();
    }

    @Override
    public List<PatientDTO> getAll() throws SQLException, ClassNotFoundException {
        List<Patient> patients = patientDAO.getAll();
        List<PatientDTO> dtoList = new ArrayList<>();
        for (Patient patient : patients) {
            dtoList.add(new PatientDTO(
                    patient.getPatientId(),
                    patient.getName(),
                    patient.getAddress(),
                    patient.getGender(),
                    patient.getBirth(),
                    patient.getPhone(),
                    patient.getRegistrationDate()
            ));
        }
        return dtoList;
    }
}
