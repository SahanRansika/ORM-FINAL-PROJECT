package healthcarecenter.dao.impl;

import healthcarecenter.dao.CrudDAO;
import healthcarecenter.entity.Payment;

import java.sql.SQLException;
import java.util.ArrayList;

public class PaymentDAOImpl implements CrudDAO<Payment> {
    @Override
    public boolean save(Payment entity) throws SQLException{
        return false;
    }

    @Override
    public boolean update(Payment entity) throws SQLException,ClassNotFoundException{
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
    public ArrayList<Payment> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}
