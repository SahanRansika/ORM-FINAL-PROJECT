package healthcarecenter.bo.impl;

import healthcarecenter.bo.RegistrationBO;
import healthcarecenter.dao.DAOFactory;
import healthcarecenter.dao.RegistrationDAO;
import healthcarecenter.dto.RegistrationDTO;
import healthcarecenter.entity.Registration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegistrationBOImpl implements RegistrationBO {
    RegistrationDAO registrationDAO = (RegistrationDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.REGISTRATION);
    @Override
    public boolean save(RegistrationDTO registrationDTO) throws SQLException,ClassNotFoundException{
        boolean save = registrationDAO.save(new Registration(
                registrationDTO.getRegistrationId(),
                registrationDTO.getPatientId(),
                registrationDTO.getProgramId(),
                registrationDTO.getRegistrationDate()
        ));
        return save;
    }

    @Override
    public boolean update(RegistrationDTO registrationDTO) throws SQLException,ClassNotFoundException{
        return registrationDAO.update(new Registration(
                registrationDTO.getRegistrationId(),
                registrationDTO.getPatientId(),
                registrationDTO.getProgramId(),
                registrationDTO.getRegistrationDate()
        ));
    }

    @Override
    public boolean delete(String id) throws SQLException,ClassNotFoundException{
        return registrationDAO.delete(id);
    }

    @Override
    public String getNextRegistrationId() throws SQLException, ClassNotFoundException {
        return registrationDAO.generateNewId();
    }

    @Override
    public List<RegistrationDTO> getAll() throws SQLException, ClassNotFoundException {
        List<Registration> registrations = registrationDAO.getAll();
        List<RegistrationDTO> dtoList = new ArrayList<>();
        for (Registration registration : registrations) {
            dtoList.add(new RegistrationDTO(
                    registration.getRegistrationId(),
                    registration.getPatientId(),
                    registration.getProgramId(),
                    registration.getRegistrationDate()
            ));
        }
        return dtoList;
    }
}
