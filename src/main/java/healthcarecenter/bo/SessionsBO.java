package healthcarecenter.bo;

import healthcarecenter.dto.SessionsDTO;

import java.sql.SQLException;

public interface SessionsBO extends SuperBO{
    boolean save(SessionsDTO sessionDTO) throws SQLException,ClassNotFoundException;
    String getNextSessionId() throws SQLException,ClassNotFoundException;
}
