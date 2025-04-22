package healthcarecenter.dao.impl;

import healthcarecenter.dao.CrudDAO;
import healthcarecenter.entity.Registration;

import java.sql.SQLException;
import java.util.List;

public class RegistrationDAOImpl implements CrudDAO<Registration> {
    @Override
    public boolean save(Registration entity) throws SQLException,ClassNotFoundException{
        return false;
    }

    @Override
public boolean update(Registration entity) throws SQLException,ClassNotFoundException{
        return false;
    }

    @Override
public boolean delete(String id) throws SQLException,ClassNotFoundException{
        return false;
    }

    @Override
public String generateNewId() throws SQLException,ClassNotFoundException{
        return "";
    }

    @Override
    public List<Registration> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}
