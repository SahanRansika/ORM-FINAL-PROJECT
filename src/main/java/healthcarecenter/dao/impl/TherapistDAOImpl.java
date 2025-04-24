package healthcarecenter.dao.impl;

import healthcarecenter.config.FactoryConfiguration;
import healthcarecenter.dao.TherapistDAO;
import healthcarecenter.entity.Therapist;
import javafx.scene.control.Alert;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TherapistDAOImpl implements TherapistDAO {

    @Override
    public boolean save(Therapist entity) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Therapist existing = session.get(Therapist.class, entity.getTherapistId());
            if (existing != null) {
                new Alert(Alert.AlertType.ERROR, "THERAPIST ALREADY EXISTS").show();
                return false;
            }

            session.persist(entity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean update(Therapist entity) throws SQLException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.merge(entity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Therapist therapist = session.get(Therapist.class, id);
            if (therapist != null) {
                session.remove(therapist);
                transaction.commit();
                return true;
            } else {
                new Alert(Alert.AlertType.ERROR, "THERAPIST NOT FOUND").show();
                return false;
            }
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            Query<String> query = session.createQuery("SELECT t.therapistId FROM Therapist t ORDER BY t.therapistId DESC", String.class);
            query.setMaxResults(1);
            String lastId = query.uniqueResult();
            transaction.commit();

            if (lastId != null) {
                int lastNum = Integer.parseInt(lastId.replace("T", ""));
                int nextNum = lastNum + 1;
                return String.format("T%03d", nextNum);
            } else {
                return "T001";
            }
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException("Error generating therapist ID", e);
        } finally {
            session.close();
        }
    }

    @Override
    public ArrayList<Therapist> getAll() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        try {
            List<Therapist> list = session.createQuery("FROM Therapist", Therapist.class).list();
            return new ArrayList<>(list);
        } finally {
            session.close();
        }
    }

    @Override
    public Therapist findById(String id) throws SQLException,ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        try {
            return session.get(Therapist.class, id);
        } finally {
            session.close();
        }
    }
}
