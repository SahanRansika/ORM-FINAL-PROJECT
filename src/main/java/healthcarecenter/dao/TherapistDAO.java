package healthcarecenter.dao;

import healthcarecenter.entity.Therapist;

import java.sql.SQLException;

public interface TherapistDAO extends CrudDAO<Therapist>{
    Therapist findById(String id) throws SQLException,ClassNotFoundException;
}
