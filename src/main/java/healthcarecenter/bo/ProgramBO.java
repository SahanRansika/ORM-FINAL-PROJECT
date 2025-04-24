package healthcarecenter.bo;

import healthcarecenter.dto.ProgramDTO;
import healthcarecenter.dto.TherapistDTO;

import java.sql.SQLException;
import java.util.List;

public interface ProgramBO extends SuperBO{
    boolean save(ProgramDTO programDTO) throws SQLException,ClassNotFoundException;
    boolean update(ProgramDTO programDTO) throws SQLException,ClassNotFoundException;
    boolean delete(String id) throws SQLException,ClassNotFoundException;
    String getNextProgramId() throws SQLException,ClassNotFoundException;
    List<ProgramDTO> getAll() throws SQLException,ClassNotFoundException;
    List<TherapistDTO> loadTherapistIds() throws SQLException,ClassNotFoundException;
}
