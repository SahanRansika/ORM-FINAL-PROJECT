package healthcarecenter.bo;

import healthcarecenter.dto.PaymentDTO;

import java.sql.SQLException;
import java.util.List;

public interface PaymentBO extends SuperBO{
    boolean save(PaymentDTO paymentDTO);
    boolean update(PaymentDTO paymentDTO);
    boolean delete(String id);
    String getNextPaymentId() throws SQLException,ClassNotFoundException;
    List<PaymentDTO> getAll() throws SQLException,ClassNotFoundException;
}
