package healthcarecenter.dao.impl;

import healthcarecenter.config.FactoryConfiguration;
import healthcarecenter.dao.PatientDAO;
import healthcarecenter.entity.Patient;
import javafx.scene.control.Alert;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;

public class PatientDAOImpl implements PatientDAO {

    @Override
    public boolean save(Patient entity) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Patient patient = session.get(Patient.class, entity.getPatientId());
            if (patient != null) {
                new Alert(Alert.AlertType.ERROR, "PATIENT ALREADY EXISTS").show();
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
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public boolean update(Patient entity) throws SQLException, ClassNotFoundException {
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
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Patient patient = session.get(Patient.class, id);
            if (patient != null) {
                session.remove(patient);
                transaction.commit();
                return true;
            } else {
                new Alert(Alert.AlertType.ERROR, "PATIENT NOT FOUND").show();
                return false;
            }
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Query<String> query = session.createQuery(
                    "SELECT p.patientId FROM Patient p ORDER BY p.patientId DESC", String.class
            );
            query.setMaxResults(1);
            String lastId = query.uniqueResult();

            transaction.commit();

            if (lastId != null) {
                int lastNum = Integer.parseInt(lastId.replace("P", ""));
                int nextNum = lastNum + 1;
                return String.format("P%03d", nextNum);
            } else {
                return "P001";
            }
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException("NO PATIENT ID", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public ArrayList<Patient> getAll() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        try {
            return (ArrayList<Patient>) session.createQuery("FROM Patient", Patient.class).list();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
