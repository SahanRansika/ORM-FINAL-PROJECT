package healthcarecenter.dao.impl;

import healthcarecenter.config.FactoryConfiguration;
import healthcarecenter.dao.PatientDAO;
import healthcarecenter.entity.Patient;
import javafx.scene.control.Alert;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class PatientDAOImpl implements PatientDAO {
    @Override
    public boolean save(Patient entity) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Patient patient = session.get(Patient.class, entity.getColPatientId());
            if (patient != null){
                new Alert(Alert.AlertType.ERROR,"Patient already exists").show();
            }

            session.persist(entity);
            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }finally {
            if (session != null) {
                session.close();
            }
        }
    }
    @Override
    public boolean update(Patient entity) throws SQLException,ClassNotFoundException{
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException,ClassNotFoundException{
        return false;
    }

    @Override
public String generateNewId() throws SQLException,ClassNotFoundException{
        return "";
    }

    @Override
    public List<Patient> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}
