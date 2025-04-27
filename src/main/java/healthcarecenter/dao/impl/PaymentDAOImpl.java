package healthcarecenter.dao.impl;

import healthcarecenter.config.FactoryConfiguration;
import healthcarecenter.dao.PaymentDAO;
import healthcarecenter.entity.Payment;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class PaymentDAOImpl implements PaymentDAO {

    @Override
    public List<Payment> getAll() throws SQLException,ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query<Payment> query = session.createQuery("FROM Payment", Payment.class);
        List<Payment> list = query.list();

        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public boolean update(Payment payment) throws SQLException,ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(payment);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String paymentId) throws SQLException,ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Payment payment = session.get(Payment.class, paymentId);
        if (payment != null) {
            session.delete(payment);
            transaction.commit();
            session.close();
            return true;
        }
        session.close();
        return false;
    }

    @Override
    public Payment findById(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Payment entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        return "";
    }
}
