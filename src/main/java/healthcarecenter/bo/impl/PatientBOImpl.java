package healthcarecenter.bo.impl;

import healthcarecenter.bo.PatientBO;
import healthcarecenter.dao.DAOFactory;
import healthcarecenter.dao.PatientDAO;
import healthcarecenter.dto.PatientDTO;
import healthcarecenter.entity.Patient;

import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class PatientBOImpl implements PatientBO {
    PatientDAO patientDAO = (PatientDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.PATIENT);

    @Override
    public boolean save(PatientDTO patientDTO) throws SQLException, ClassNotFoundException {
        Date birthDate = Date.valueOf(patientDTO.getBirth().toString());
        return patientDAO.save(new Patient(
                patientDTO.getPatientId(),
                patientDTO.getName(),
                patientDTO.getAddress(),
                patientDTO.getGender(),
                birthDate,
                patientDTO.getPhone(),
                patientDTO.getRegistrationDate()
        ));
    }

    @Override
    public boolean update(PatientDTO patientDTO) throws SQLException, ClassNotFoundException {
        Date birthDate = Date.valueOf(patientDTO.getBirth().toString());

        return patientDAO.update(new Patient(
                patientDTO.getPatientId(),
                patientDTO.getName(),
                patientDTO.getAddress(),
                patientDTO.getGender(),
                birthDate,
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

    @Override
    public PatientDTO findById(String id) throws SQLException, ClassNotFoundException {
        Patient patient = patientDAO.findById(id);
        if (patient != null) {
            return new PatientDTO(
                    patient.getPatientId(),
                    patient.getName(),
                    patient.getAddress(),
                    patient.getGender(),
                    patient.getBirth(),
                    patient.getPhone(),
                    patient.getRegistrationDate()
            );
        }
        return null;
    }
}
