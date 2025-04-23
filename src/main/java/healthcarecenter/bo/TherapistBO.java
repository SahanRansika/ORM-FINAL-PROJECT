package healthcarecenter.bo;

import healthcarecenter.dto.TherapistDTO;

import java.sql.SQLException;
import java.util.List;

public interface TherapistBO extends SuperBO{
    boolean save(TherapistDTO therapistDTO) throws SQLException,ClassNotFoundException;
    boolean update(TherapistDTO therapistDTO) throws SQLException,ClassNotFoundException;
    boolean delete(String id) throws SQLException,ClassNotFoundException;
    String getNextTherapistId() throws SQLException,ClassNotFoundException;
    List<TherapistDTO> getAll() throws SQLException,ClassNotFoundException;
}
