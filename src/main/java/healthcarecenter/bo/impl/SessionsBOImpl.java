package healthcarecenter.bo.impl;

import healthcarecenter.bo.SessionsBO;
import healthcarecenter.dto.SessionsDTO;

public class SessionsBOImpl implements SessionsBO {
    @Override
    public boolean save(SessionsDTO sessionDTO) {
        return false;
    }

    @Override
    public String getNextSessionId() {
        return "";
    }
}
