package healthcarecenter.bo.impl;

import healthcarecenter.bo.ProgramBO;
import healthcarecenter.dao.DAOFactory;
import healthcarecenter.dao.ProgramDAO;
import healthcarecenter.dao.TherapistDAO;
import healthcarecenter.dto.ProgramDTO;
import healthcarecenter.dto.TherapistDTO;
import healthcarecenter.entity.Program;
import healthcarecenter.entity.Therapist;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProgramBOImpl implements ProgramBO {

    ProgramDAO programDAO = (ProgramDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.PROGRAM);
    TherapistDAO therapistDAO = (TherapistDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.THERAPIST);

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

    @Override
    public List<TherapistDTO> loadTherapistIds() throws SQLException, ClassNotFoundException {
        List<Therapist> therapists = therapistDAO.getAll();
        List<TherapistDTO> therapistDTOS = new ArrayList<>();
        for (Therapist therapist : therapists){
            therapistDTOS.add(new TherapistDTO(
                    therapist.getTherapistId(),
                    therapist.getName(),
                    therapist.getSpec(),
                    therapist.getYears(),
                    therapist.getPhone(),
                    therapist.getAssigned()
            ));
        }
        return therapistDTOS;
    }
}
