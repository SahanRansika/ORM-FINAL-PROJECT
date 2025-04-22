package healthcarecenter.bo.impl;

import healthcarecenter.bo.SessionBO;
import healthcarecenter.dto.SessionsDTO;

public class SessionBOImpl implements SessionBO {
    @Override
    public boolean save(SessionsDTO sessionDTO) {
        return false;
    }

    @Override
    public String getNextId() {
        return "";
    }
}
