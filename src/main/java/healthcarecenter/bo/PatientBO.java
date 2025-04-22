package healthcarecenter.bo;

import healthcarecenter.dto.PatientDTO;

import java.util.ArrayList;

public interface PatientBO extends SuperBO{
    boolean save(PatientDTO patientDTO);
    boolean update(PatientDTO patientDTO);
    boolean delete(String id);
//    ArrayList<PatientDTO> getAll();
    String getNextId();
}
