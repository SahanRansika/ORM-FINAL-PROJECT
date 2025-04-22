package healthcarecenter.bo;

import healthcarecenter.dto.PatientDTO;

import java.sql.SQLException;
import java.util.List;

public interface PatientBO extends SuperBO{
    boolean savePatient(PatientDTO patientDTO) throws SQLException,ClassNotFoundException;
    boolean updatePatient(PatientDTO patientDTO) throws SQLException,ClassNotFoundException;
    boolean deletePatient(String id) throws SQLException,ClassNotFoundException;
    String getNextPatientId() throws SQLException,ClassNotFoundException;
    List<PatientDTO> getAllPatient() throws SQLException,ClassNotFoundException;
}
