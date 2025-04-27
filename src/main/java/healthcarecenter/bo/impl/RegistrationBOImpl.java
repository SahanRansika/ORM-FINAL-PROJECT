package healthcarecenter.bo.impl;

import healthcarecenter.bo.RegistrationBO;
import healthcarecenter.dao.DAOFactory;
import healthcarecenter.dao.PatientDAO;
import healthcarecenter.dao.ProgramDAO;
import healthcarecenter.dao.RegistrationDAO;
import healthcarecenter.dto.PatientDTO;
import healthcarecenter.dto.ProgramDTO;
import healthcarecenter.dto.RegistrationDTO;
import healthcarecenter.entity.Patient;
import healthcarecenter.entity.Program;
import healthcarecenter.entity.Registration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegistrationBOImpl implements RegistrationBO {

    RegistrationDAO registrationDAO = (RegistrationDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.REGISTRATION);
    PatientDAO patientDAO = (PatientDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.PATIENT);
    ProgramDAO programDAO = (ProgramDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.PROGRAM);

    @Override
    public boolean save(RegistrationDTO registrationDTO) throws SQLException, ClassNotFoundException {
        Patient patient = patientDAO.findById(registrationDTO.getPatientId());
        Program program = programDAO.findById(registrationDTO.getProgramId());

        if (patient == null || program == null) {
            return false;
        }

        Registration registration = new Registration();
        registration.setRegistrationId(registrationDTO.getRegistrationId());
        registration.setPatient(patient);
        registration.setProgram(program);
        registration.setRegistrationDate(registrationDTO.getRegistrationDate());

        return registrationDAO.save(registration);
    }

    @Override
    public boolean update(RegistrationDTO registrationDTO) throws SQLException, ClassNotFoundException {
        Patient patient = patientDAO.findById(registrationDTO.getPatientId());
        Program program = programDAO.findById(registrationDTO.getProgramId());

        if (patient == null || program == null) {
            return false;
        }

        Registration registration = new Registration();
        registration.setRegistrationId(registrationDTO.getRegistrationId());
        registration.setPatient(patient);
        registration.setProgram(program);
        registration.setRegistrationDate(registrationDTO.getRegistrationDate()); // Already a java.sql.Date

        return registrationDAO.update(registration);
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return registrationDAO.delete(id);
    }

    @Override
    public String getNextRegistrationId() throws SQLException, ClassNotFoundException {
        return registrationDAO.generateNewId();
    }

    @Override
    public List<RegistrationDTO> getAll() throws SQLException, ClassNotFoundException {
        List<Registration> registrations = registrationDAO.getAll();
        List<RegistrationDTO> dtoList = new ArrayList<>();
        for (Registration registration : registrations) {
            dtoList.add(new RegistrationDTO(
                    registration.getRegistrationId(),
                    registration.getPatient().getPatientId(),
                    registration.getProgram().getProgramId(),
                    registration.getRegistrationDate()
            ));
        }
        return dtoList;
    }

    @Override
    public List<PatientDTO> loadPatientIds() throws SQLException, ClassNotFoundException {
        List<Patient> patients = patientDAO.getAll();
        List<PatientDTO> patientDTOS = new ArrayList<>();
        for (Patient patient : patients) {
            patientDTOS.add(new PatientDTO(
                    patient.getPatientId(),
                    patient.getName(),
                    patient.getAddress(),
                    patient.getGender(),
                    patient.getBirth(),
                    patient.getPhone(),
                    patient.getRegistrationDate()
            ));
        }
        return patientDTOS;
    }

    @Override
    public List<ProgramDTO> loadProgramIds() throws SQLException, ClassNotFoundException {
        List<Program> programs = programDAO.getAll();
        List<ProgramDTO> programDTOS = new ArrayList<>();
        for (Program program : programs) {
            programDTOS.add(new ProgramDTO(
                    program.getProgramId(),
                    program.getTherapist().getTherapistId(), // Updated to use therapistId from Therapist
                    program.getName(),
                    program.getDuration(),
                    program.getCost(),
                    program.getDescription()
            ));
        }
        return programDTOS;
    }
}
