package healthcarecenter.bo.impl;

import healthcarecenter.bo.SessionBO;
import healthcarecenter.dto.SessionDTO;

public class SessionBOImpl implements SessionBO {
    @Override
    public boolean save(SessionDTO sessionDTO) {
        return false;
    }

    @Override
    public String getNextId() {
        return "";
    }
}
