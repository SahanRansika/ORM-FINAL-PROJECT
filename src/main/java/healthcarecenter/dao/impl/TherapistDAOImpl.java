package healthcarecenter.dao.impl;

import healthcarecenter.config.FactoryConfiguration;
import healthcarecenter.dao.CrudDAO;
import healthcarecenter.entity.Registration;
import healthcarecenter.entity.Therapist;
import javafx.scene.control.Alert;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;

public class TherapistDAOImpl implements CrudDAO<Therapist> {
    @Override
    public boolean save(Therapist entity) throws SQLException,ClassNotFoundException{
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Therapist therapist = session.get(Therapist.class, entity.getTherapistId());
            if (therapist != null){
                new Alert(Alert.AlertType.ERROR,"THERAPIST ALREADY EXISTS").show();
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
    public boolean update(Therapist entity) throws SQLException{
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
    public ArrayList<Therapist> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}
