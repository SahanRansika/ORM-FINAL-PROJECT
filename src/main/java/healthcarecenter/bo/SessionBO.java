package healthcarecenter.bo;

import healthcarecenter.dto.SessionsDTO;

public interface SessionBO extends SuperBO{
    boolean save(SessionsDTO sessionDTO);
    String getNextId();
}
