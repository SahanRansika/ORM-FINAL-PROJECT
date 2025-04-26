package healthcarecenter.bo;

import healthcarecenter.dto.PatientDTO;
import healthcarecenter.dto.ProgramDTO;
import healthcarecenter.dto.SessionsDTO;
import healthcarecenter.dto.TherapistDTO;

import java.sql.SQLException;
import java.util.List;

public interface SessionsBO extends SuperBO{
    boolean save(SessionsDTO sessionDTO) throws SQLException,ClassNotFoundException;
    String getNextSessionId() throws SQLException,ClassNotFoundException;
    List<PatientDTO> loadPatientIds() throws SQLException,ClassNotFoundException;
    List<ProgramDTO> loadProgramIds() throws SQLException,ClassNotFoundException;
}
