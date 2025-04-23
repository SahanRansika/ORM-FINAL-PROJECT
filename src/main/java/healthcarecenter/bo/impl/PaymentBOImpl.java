package healthcarecenter.bo.impl;

import healthcarecenter.bo.PaymentBO;
import healthcarecenter.dao.DAOFactory;
import healthcarecenter.dao.PaymentDAO;
import healthcarecenter.dto.PaymentDTO;

import java.sql.SQLException;
import java.util.List;

public class PaymentBOImpl implements PaymentBO {

    PaymentDAO paymentDAO = (PaymentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.PAYMENT);

    @Override
    public boolean save(PaymentDTO paymentDTO) {
        return false;
    }

    @Override
    public boolean update(PaymentDTO paymentDTO) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public String getNextPaymentId() throws SQLException, ClassNotFoundException {
        return "";
    }

    @Override
    public List<PaymentDTO> getAll() throws SQLException, ClassNotFoundException {
        return List.of();
    }
}
