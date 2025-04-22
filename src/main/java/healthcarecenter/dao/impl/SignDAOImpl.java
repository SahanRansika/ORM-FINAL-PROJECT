package healthcarecenter.dao.impl;

import healthcarecenter.dao.SignDAO;
import healthcarecenter.entity.Sign;

public class SignDAOImpl implements SignDAO {
    @Override
    public boolean save(Sign entity) {
        return false;
    }

    @Override
    public boolean update(Sign entity) {
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
