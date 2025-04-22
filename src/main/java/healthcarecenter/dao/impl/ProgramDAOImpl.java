package healthcarecenter.dao.impl;

import healthcarecenter.dao.CrudDAO;
import healthcarecenter.entity.Program;

import java.sql.SQLException;
import java.util.List;

public class ProgramDAOImpl implements CrudDAO<Program> {
    @Override
    public boolean save(Program entity) throws SQLException,ClassNotFoundException{
        return false;
    }

    @Override
    public boolean update(Program entity) throws SQLException,ClassNotFoundException{
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
    public List<Program> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}
