package healthcarecenter.dao.impl;

import healthcarecenter.config.FactoryConfiguration;
import healthcarecenter.dao.CrudDAO;
import healthcarecenter.entity.Program;
import javafx.scene.control.Alert;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProgramDAOImpl implements CrudDAO<Program> {
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
    public ArrayList<Program> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}
