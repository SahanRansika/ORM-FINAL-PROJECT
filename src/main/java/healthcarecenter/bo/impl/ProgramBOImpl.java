package healthcarecenter.bo.impl;

import healthcarecenter.bo.ProgramBO;
import healthcarecenter.dao.DAOFactory;
import healthcarecenter.dao.ProgramDAO;
import healthcarecenter.dto.PatientDTO;
import healthcarecenter.dto.ProgramDTO;
import healthcarecenter.entity.Program;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProgramBOImpl implements ProgramBO {

    ProgramDAO programDAO = (ProgramDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.PROGRAM);

    @Override
    public boolean save(ProgramDTO programDTO) throws SQLException,ClassNotFoundException{
        boolean save = programDAO.save(new Program(
                programDTO.getProgramId(),
                programDTO.getTherapistId(),
                programDTO.getName(),
                programDTO.getDuration(),
                programDTO.getCost(),
                programDTO.getDescription()
        ));
        return save;
    }

    @Override
    public boolean update(ProgramDTO programDTO) throws SQLException,ClassNotFoundException{
        return programDAO.update(new Program(
                programDTO.getProgramId(),
                programDTO.getTherapistId(),
                programDTO.getName(),
                programDTO.getDuration(),
                programDTO.getCost(),
                programDTO.getDescription()
        ));
    }

    @Override
    public boolean delete(String id) throws SQLException,ClassNotFoundException{
        return programDAO.delete(id);
    }

    @Override
    public String getNextProgramId() throws SQLException, ClassNotFoundException {
        return programDAO.generateNewId();
    }

    @Override
    public List<ProgramDTO> getAll() throws SQLException, ClassNotFoundException {
        List<Program> programs = programDAO.getAll();
        List<ProgramDTO> dtoList = new ArrayList<>();
        for (Program program : programs) {
            dtoList.add(new ProgramDTO(
                    program.getProgramId(),
                    program.getTherapistId(),
                    program.getName(),
                    program.getDuration(),
                    program.getCost(),
                    program.getDescription()
            ));
        }
        return dtoList;
    }
}
