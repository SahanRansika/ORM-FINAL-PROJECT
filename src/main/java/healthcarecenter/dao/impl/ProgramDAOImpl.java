package healthcarecenter.dao.impl;

import healthcarecenter.config.FactoryConfiguration;
import healthcarecenter.dao.ProgramDAO;
import healthcarecenter.entity.Program;
import healthcarecenter.entity.Therapist;
import javafx.scene.control.Alert;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProgramDAOImpl implements ProgramDAO {

    @Override
    public boolean save(Program entity) throws SQLException,ClassNotFoundException{
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Program program = session.get(Program.class, entity.getProgramId());
            if (program != null){
                new Alert(Alert.AlertType.ERROR,"PROGRAM ALREADY EXISTS").show();
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
    public boolean update(Program entity) throws SQLException,ClassNotFoundException{
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
            Program program = session.get(Program.class, id);
            if (program != null) {
                session.remove(program);
                transaction.commit();
                return true;
            } else {
                new Alert(Alert.AlertType.ERROR, "PROGRAM NOT FOUND").show();
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
                    "SELECT p.programId FROM Program p ORDER BY p.programId DESC", String.class
            );
            query.setMaxResults(1);
            String lastId = query.uniqueResult();

            transaction.commit();

            if (lastId != null) {
                int lastNum = Integer.parseInt(lastId.replace("PR", ""));
                int nextNum = lastNum + 1;
                return String.format("PR%03d", nextNum);
            } else {
                return "PR001";
            }
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException("NO PROGRAM ID", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public ArrayList<Program> getAll() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        try {
            return (ArrayList<Program>) session.createQuery("FROM Program ", Program.class).list();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Program findById(String id) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        try {
            return session.get(Program.class, id);
        } finally {
            session.close();
        }
    }
}
