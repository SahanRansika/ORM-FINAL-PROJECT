package healthcarecenter.bo;

import healthcarecenter.dto.RegistrationDTO;

public interface RegistrationBO extends SuperBO{
    boolean save(RegistrationDTO registrationDTO);
    boolean update(RegistrationDTO registrationDTO);
    boolean delete(String id);
    String getNextId();
}
