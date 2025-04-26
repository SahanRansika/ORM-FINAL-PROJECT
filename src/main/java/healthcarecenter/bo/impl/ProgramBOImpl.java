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
    public boolean save(ProgramDTO programDTO) throws SQLException, ClassNotFoundException {
        Therapist therapist = therapistDAO.findById(programDTO.getTherapistId());
        if (therapist == null) {
            return false;
        }
        Program program = new Program();
        program.setProgramId(programDTO.getProgramId());
        program.setName(programDTO.getName());
        program.setDuration(programDTO.getDuration());
        program.setCost(programDTO.getCost());
        program.setDescription(programDTO.getDescription());
        program.setTherapist(therapist);

        return programDAO.save(program);
    }

    @Override
    public boolean update(ProgramDTO programDTO) throws SQLException, ClassNotFoundException {
        Therapist therapist = therapistDAO.findById(programDTO.getTherapistId());
        if (therapist == null) {
            return false;
        }
        Program program = new Program();
        program.setProgramId(programDTO.getProgramId());
        program.setName(programDTO.getName());
        program.setDuration(programDTO.getDuration());
        program.setCost(programDTO.getCost());
        program.setDescription(programDTO.getDescription());
        program.setTherapist(therapist);

        return programDAO.update(program);
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
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
                    program.getTherapist().getTherapistId(),
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
        for (Therapist therapist : therapists) {
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

    @Override
    public ProgramDTO findById(String id) throws SQLException, ClassNotFoundException {
        Program program = programDAO.findById(id);
        if (program != null) {
            return new ProgramDTO(
                    program.getProgramId(),
                    program.getTherapist().getTherapistId(),
                    program.getName(),
                    program.getDuration(),
                    program.getCost(),
                    program.getDescription()
            );
        }
        return null;

    }
}
