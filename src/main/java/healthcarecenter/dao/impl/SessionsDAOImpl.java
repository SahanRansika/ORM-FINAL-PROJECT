package healthcarecenter.dao.impl;

import healthcarecenter.config.FactoryConfiguration;
import healthcarecenter.dao.CrudDAO;
import healthcarecenter.dao.SessionsDAO;
import healthcarecenter.entity.Patient;
import healthcarecenter.entity.Sessions;
import javafx.scene.control.Alert;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;

public class SessionsDAOImpl implements SessionsDAO {
    @Override
    public boolean save(Sessions entity) throws SQLException,ClassNotFoundException{
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Sessions sessions = session.get(Sessions.class, entity.getSessionId());
            if (sessions != null) {
                new Alert(Alert.AlertType.ERROR, "SESSIONS ALREADY EXISTS").show();
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
    public boolean update(Sessions entity) throws SQLException{
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
            Sessions sessions = session.get(Sessions.class, id);
            if (sessions != null) {
                session.remove(sessions);
                transaction.commit();
                return true;
            } else {
                new Alert(Alert.AlertType.ERROR, "SESSIONS NOT FOUND").show();
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
                    "SELECT s.sessionId FROM Sessions s ORDER BY s.sessionId DESC", String.class
            );
            query.setMaxResults(1);
            String lastId = query.uniqueResult();

            transaction.commit();

            if (lastId != null) {
                int lastNum = Integer.parseInt(lastId.replace("S", ""));
                int nextNum = lastNum + 1;
                return String.format("S%03d", nextNum);
            } else {
                return "S001";
            }
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException("NO SESSIONS ID", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public ArrayList<Sessions> getAll() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        try {
            return (ArrayList<Sessions>) session.createQuery("FROM Sessions ", Sessions.class).list();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Sessions findById(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
