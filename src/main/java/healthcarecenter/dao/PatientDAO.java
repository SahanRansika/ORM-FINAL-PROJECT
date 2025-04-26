package healthcarecenter.dao;

import healthcarecenter.entity.Patient;

import java.sql.SQLException;

public interface PatientDAO extends CrudDAO<Patient> {
    Patient findById(String id) throws SQLException,ClassNotFoundException;
}
