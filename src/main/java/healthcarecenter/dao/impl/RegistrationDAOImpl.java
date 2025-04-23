package healthcarecenter.dao.impl;

import healthcarecenter.config.FactoryConfiguration;
import healthcarecenter.dao.CrudDAO;
import healthcarecenter.dao.RegistrationDAO;
import healthcarecenter.entity.Program;
import healthcarecenter.entity.Registration;
import javafx.scene.control.Alert;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;

public class RegistrationDAOImpl implements RegistrationDAO {
    @Override
    public boolean save(Registration entity) throws SQLException,ClassNotFoundException{
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Registration registration = session.get(Registration.class, entity.getRegistrationId());
            if (registration != null){
                new Alert(Alert.AlertType.ERROR,"REGISTRATION ALREADY EXISTS").show();
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
public boolean update(Registration entity) throws SQLException,ClassNotFoundException{
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
public boolean delete(String id) throws SQLException,ClassNotFoundException{
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Registration registration = session.get(Registration.class, id);
            if (registration != null) {
                session.remove(registration);
                transaction.commit();
                return true;
            } else {
                new Alert(Alert.AlertType.ERROR, "REGISTRATION NOT FOUND").show();
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
public String generateNewId() throws SQLException,ClassNotFoundException{
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Query<String> query = session.createQuery(
                    "SELECT r.registrationId FROM Registration r ORDER BY r.registrationId DESC", String.class
            );
            query.setMaxResults(1);
            String lastId = query.uniqueResult();

            transaction.commit();

            if (lastId != null) {
                int lastNum = Integer.parseInt(lastId.replace("R", ""));
                int nextNum = lastNum + 1;
                return String.format("R%03d", nextNum);
            } else {
                return "R001";
            }
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException("NO REGISTRATION ID", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public ArrayList<Registration> getAll() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        try {
            return (ArrayList<Registration>) session.createQuery("FROM Registration ", Registration.class).list();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
