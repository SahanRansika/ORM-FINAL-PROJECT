package healthcarecenter.bo;

import healthcarecenter.dto.PaymentDTO;

public interface PaymentBO extends SuperBO{
    boolean save(PaymentDTO paymentDTO);
    boolean update(PaymentDTO paymentDTO);
    boolean delete(String id);
    String getNextId();
}
