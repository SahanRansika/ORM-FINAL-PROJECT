package healthcarecenter.bo;

import healthcarecenter.dto.SessionDTO;

public interface SessionBO extends SuperBO{
    boolean save(SessionDTO sessionDTO);
    String getNextId();
}
