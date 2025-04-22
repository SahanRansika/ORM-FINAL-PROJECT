package healthcarecenter.bo;

import healthcarecenter.dto.ProgramDTO;

public interface ProgramBO extends SuperBO{
    boolean save(ProgramDTO programDTO);
    boolean update(ProgramDTO programDTO);
    boolean delete(String id);
    String getNextId();
}
