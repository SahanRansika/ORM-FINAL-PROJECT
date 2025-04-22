package healthcarecenter.dao.impl;

import healthcarecenter.dao.CrudDAO;
import healthcarecenter.entity.Sessions;

public class SessionDAOImpl implements CrudDAO<Sessions> {
    @Override
    public boolean save(Sessions entity) {
        return false;
    }

    @Override
    public boolean update(Sessions entity) {
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
