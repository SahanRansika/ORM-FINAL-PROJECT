package healthcarecenter.dao.impl;

import healthcarecenter.dao.LoginDAO;
import healthcarecenter.entity.Login;

public class LoginDAOImpl implements LoginDAO {
    @Override
    public boolean save(Login entity) {
        return false;
    }

    @Override
    public boolean update(Login entity) {
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
