package healthcarecenter.bo.impl;

import healthcarecenter.bo.SessionsBO;
import healthcarecenter.dao.*;
import healthcarecenter.dto.SessionsDTO;
import healthcarecenter.entity.Patient;
import healthcarecenter.entity.Sessions;

import java.sql.SQLException;

public class SessionsBOImpl implements SessionsBO {

    SessionsDAO sessionsDAO = (SessionsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.SESSIONS);
    PatientDAO patientDAO = (PatientDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.PATIENT);

    @Override
    public boolean save(SessionsDTO sessionDTO) throws SQLException, ClassNotFoundException {
//        Sessions session = sessionsDAO.findById(sessionDTO.getSessionId());
        Patient patient = patientDAO.findById(sessionDTO.getPatientId());

//        if (session != null ) {
            Sessions sessions = new Sessions(
                    sessionDTO.getSessionId(),
                    patient,
                    sessionDTO.getSessionDate()
            );
            return sessionsDAO.save(sessions);
//        } else {
//            return false;
//        }
    }

    @Override
    public String getNextSessionId() throws SQLException, ClassNotFoundException {
        return sessionsDAO.generateNewId();
    }

    public SessionsDTO findById(String id) throws SQLException, ClassNotFoundException {
        Sessions sessions = sessionsDAO.findById(id);
        if (sessions != null) {
            return new SessionsDTO(
                    sessions.getSessionId(),
                    sessions.getPatient().getPatientId(),
                    sessions.getSessionDate()

            );
        }
        return null;
    }
}
