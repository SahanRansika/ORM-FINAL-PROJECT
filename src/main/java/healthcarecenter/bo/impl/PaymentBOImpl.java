package healthcarecenter.bo.impl;

import healthcarecenter.bo.PaymentBO;
import healthcarecenter.dto.PaymentDTO;

public class PaymentBOImpl implements PaymentBO {
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
    public String getNextId() {
        return null;
    }
}
