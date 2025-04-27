package healthcarecenter.bo;

import healthcarecenter.dto.PaymentDTO;

import java.sql.SQLException;
import java.util.List;

public interface PaymentBO extends SuperBO{
    boolean save(PaymentDTO paymentDTO) throws SQLException,ClassNotFoundException;
    boolean update(PaymentDTO paymentDTO) throws SQLException,ClassNotFoundException;
    boolean delete(String id) throws SQLException,ClassNotFoundException;
    List<PaymentDTO> getAll() throws SQLException,ClassNotFoundException;
}
