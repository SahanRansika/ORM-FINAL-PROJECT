package healthcarecenter.bo;

import healthcarecenter.dto.TherapistDTO;

public interface TherapistBO extends SuperBO{
    boolean save(TherapistDTO therapistDTO);
    boolean update(TherapistDTO therapistDTO);
    boolean delete(String id);
    String getNextId();
}
