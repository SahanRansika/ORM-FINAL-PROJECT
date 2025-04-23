package healthcarecenter.bo.impl;

import healthcarecenter.bo.TherapistBO;
import healthcarecenter.dao.DAOFactory;
import healthcarecenter.dao.TherapistDAO;
import healthcarecenter.dto.TherapistDTO;
import healthcarecenter.entity.Therapist;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TherapistBOImpl implements TherapistBO {

    TherapistDAO therapistDAO = (TherapistDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.THERAPIST);
    @Override
    public boolean save(TherapistDTO therapistDTO) throws SQLException,ClassNotFoundException{
        boolean save = therapistDAO.save(new Therapist(
                therapistDTO.getTherapistId(),
                therapistDTO.getName(),
                therapistDTO.getSpec(),
                therapistDTO.getYears(),
                therapistDTO.getPhone(),
                therapistDTO.getAssigned()
        ));
        return save;
    }

    @Override
    public boolean update(TherapistDTO therapistDTO) throws SQLException,ClassNotFoundException{
        return therapistDAO.update(new Therapist(
                therapistDTO.getTherapistId(),
                therapistDTO.getName(),
                therapistDTO.getSpec(),
                therapistDTO.getYears(),
                therapistDTO.getPhone(),
                therapistDTO.getAssigned()
        ));
    }

    @Override
    public boolean delete(String id) throws SQLException,ClassNotFoundException{
        return therapistDAO.delete(id);
    }

    @Override
    public String getNextTherapistId() throws SQLException, ClassNotFoundException {
        return therapistDAO.generateNewId();
    }

    @Override
    public List<TherapistDTO> getAll() throws SQLException, ClassNotFoundException {
        List<Therapist> therapists = therapistDAO.getAll();
        List<TherapistDTO> dtoList = new ArrayList<>();
        for (Therapist therapist : therapists) {
            dtoList.add(new TherapistDTO(
                    therapist.getTherapistId(),
                    therapist.getName(),
                    therapist.getSpec(),
                    therapist.getYears(),
                    therapist.getPhone(),
                    therapist.getAssigned()
            ));
        }
        return dtoList;
    }
}
