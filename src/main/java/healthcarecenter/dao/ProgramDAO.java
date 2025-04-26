package healthcarecenter.dao;

import healthcarecenter.entity.Program;

import java.sql.SQLException;

public interface ProgramDAO extends CrudDAO<Program>{
    Program findById(String id) throws SQLException,ClassNotFoundException;
}
