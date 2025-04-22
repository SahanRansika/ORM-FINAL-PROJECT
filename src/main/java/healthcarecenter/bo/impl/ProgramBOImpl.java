package healthcarecenter.bo.impl;

import healthcarecenter.bo.ProgramBO;
import healthcarecenter.dto.ProgramDTO;

public class ProgramBOImpl implements ProgramBO {
    @Override
    public boolean save(ProgramDTO programDTO) {
        return false;
    }

    @Override
    public boolean update(ProgramDTO programDTO) {
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
