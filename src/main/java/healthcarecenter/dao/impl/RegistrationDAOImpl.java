package healthcarecenter.dao.impl;

import healthcarecenter.dao.CrudDAO;
import healthcarecenter.entity.Registration;

public class RegistrationDAOImpl implements CrudDAO<Registration> {
    @Override
    public boolean save(Registration entity) {
        return false;
    }

    @Override
    public boolean update(Registration entity) {
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
