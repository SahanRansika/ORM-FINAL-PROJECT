package healthcarecenter.bo.impl;

import healthcarecenter.bo.PaymentBO;
import healthcarecenter.dao.DAOFactory;
import healthcarecenter.dao.PaymentDAO;
import healthcarecenter.dto.PaymentDTO;
import healthcarecenter.entity.Payment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentBOImpl implements PaymentBO {

    PaymentDAO paymentDAO = (PaymentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOType.PAYMENT);

    @Override
    public List<PaymentDTO> getAll() throws SQLException,ClassNotFoundException {
        List<Payment> payments = paymentDAO.getAll();
        List<PaymentDTO> dtos = new ArrayList<>();

        for (Payment payment : payments) {
            dtos.add(new PaymentDTO(
                    payment.getPaymentId(),
                    payment.getSession().getSessionId(),
                    payment.getPayment()
            ));
        }
        return dtos;
    }

    @Override
    public boolean update(PaymentDTO paymentDTO) throws SQLException,ClassNotFoundException{
        return false;
    }

    @Override
    public boolean delete(String paymentId) throws SQLException,ClassNotFoundException {
        return paymentDAO.delete(paymentId);
    }

    @Override
    public boolean save(PaymentDTO paymentDTO) throws SQLException,ClassNotFoundException{
        return false;
    }

}
