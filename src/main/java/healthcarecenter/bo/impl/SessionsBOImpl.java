package healthcarecenter.bo.impl;

import healthcarecenter.bo.SessionsBO;
import healthcarecenter.dao.*;
import healthcarecenter.dto.PatientDTO;
import healthcarecenter.dto.PaymentDTO;
import healthcarecenter.dto.ProgramDTO;
import healthcarecenter.dto.SessionsDTO;
import healthcarecenter.entity.Patient;
import healthcarecenter.entity.Payment;
import healthcarecenter.entity.Program;
import healthcarecenter.entity.Sessions;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SessionsBOImpl implements SessionsBO {

    SessionsDAO sessionsDAO = (SessionsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.SESSIONS);
    PaymentDAO paymentDAO = (PaymentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.PAYMENT);
    PatientDAO patientDAO = (PatientDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.PATIENT);
    ProgramDAO programDAO = (ProgramDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.PROGRAM);

    @Override
    public boolean save(SessionsDTO sessionDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String getNextSessionId() throws SQLException, ClassNotFoundException {
        return sessionsDAO.generateNewId();
    }

    @Override
    public List<ProgramDTO> loadProgramIds() throws SQLException, ClassNotFoundException {
        List<Program> programs = programDAO.getAll();
        List<ProgramDTO> programDTOS = new ArrayList<>();
        for (Program program : programs) {
            programDTOS.add(new ProgramDTO(
                    program.getProgramId(),
                    program.getTherapist().getTherapistId(),
                    program.getName(),
                    program.getDuration(),
                    program.getCost(),
                    program.getDescription()
            ));
        }
        return programDTOS;
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

}
