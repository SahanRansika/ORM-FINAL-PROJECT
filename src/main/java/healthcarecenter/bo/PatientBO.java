package healthcarecenter.bo;

import healthcarecenter.dto.PatientDTO;

import java.sql.SQLException;
import java.util.List;

public interface PatientBO extends SuperBO{
    boolean save(PatientDTO patientDTO) throws SQLException,ClassNotFoundException;
    boolean update(PatientDTO patientDTO) throws SQLException,ClassNotFoundException;
    boolean delete(String id) throws SQLException,ClassNotFoundException;
    String getNextPatientId() throws SQLException,ClassNotFoundException;
    List<PatientDTO> getAll() throws SQLException, ClassNotFoundException;
}
