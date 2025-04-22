package healthcarecenter.dao.impl;

import healthcarecenter.dao.CrudDAO;
import healthcarecenter.entity.Sessions;

import java.sql.SQLException;
import java.util.List;

public class SessionsDAOImpl implements CrudDAO<Sessions> {
    @Override
    public boolean save(Sessions entity) throws SQLException,ClassNotFoundException{
        return false;
    }

    @Override
    public boolean update(Sessions entity) throws SQLException{
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
    public List<Sessions> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}
