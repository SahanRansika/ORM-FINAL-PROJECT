package healthcarecenter.dao.impl;

import healthcarecenter.dao.CrudDAO;
import healthcarecenter.entity.Program;

public class ProgramDAOImpl implements CrudDAO<Program> {
    @Override
    public boolean save(Program entity) {
        return false;
    }

    @Override
    public boolean update(Program entity) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public String generateNewId() {
        return "";
    }
}
