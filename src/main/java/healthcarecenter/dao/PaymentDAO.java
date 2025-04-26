package healthcarecenter.dao;

import healthcarecenter.entity.Payment;
import healthcarecenter.entity.Sessions;

import java.sql.SQLException;

public interface PaymentDAO extends CrudDAO<Payment>{
    Payment findById(String id) throws SQLException,ClassNotFoundException;
}
