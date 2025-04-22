package healthcarecenter.bo.impl;

import healthcarecenter.bo.RegistrationBO;
import healthcarecenter.dto.RegistrationDTO;

public class RegistrationBOImpl implements RegistrationBO {
    @Override
    public boolean save(RegistrationDTO registrationDTO) {
        return false;
    }

    @Override
    public boolean update(RegistrationDTO registrationDTO) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public String getNextId() {
        return "";
    }
}
