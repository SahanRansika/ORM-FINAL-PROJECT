package healthcarecenter.bo;

import healthcarecenter.dto.RegistrationDTO;

import java.sql.SQLException;
import java.util.List;

public interface RegistrationBO extends SuperBO{
    boolean save(RegistrationDTO registrationDTO) throws SQLException,ClassNotFoundException;
    boolean update(RegistrationDTO registrationDTO) throws SQLException,ClassNotFoundException;
    boolean delete(String id) throws SQLException,ClassNotFoundException;
    String getNextRegistrationId() throws SQLException,ClassNotFoundException;
    List<RegistrationDTO> getAll() throws SQLException,ClassNotFoundException;
}
