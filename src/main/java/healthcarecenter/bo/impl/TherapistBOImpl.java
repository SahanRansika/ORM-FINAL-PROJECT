package healthcarecenter.bo.impl;

import healthcarecenter.bo.TherapistBO;
import healthcarecenter.dto.TherapistDTO;

public class TherapistBOImpl implements TherapistBO {
    @Override
    public boolean save(TherapistDTO therapistDTO) {
        return false;
    }

    @Override
    public boolean update(TherapistDTO therapistDTO) {
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
