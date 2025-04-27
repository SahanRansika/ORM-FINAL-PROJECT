package healthcarecenter.dao;

import healthcarecenter.entity.Sessions;

import java.sql.SQLException;

public interface SessionsDAO extends CrudDAO<Sessions>{
    Sessions findById(String id) throws SQLException,ClassNotFoundException;
}
