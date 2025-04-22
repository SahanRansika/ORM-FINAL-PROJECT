package healthcarecenter.bo.impl;

import healthcarecenter.bo.PatientBO;
import healthcarecenter.dto.PatientDTO;

public class PaymentBOImpl implements PatientBO {
    @Override
    public boolean save(PatientDTO patientDTO) {
        return false;
    }

    @Override
    public boolean update(PatientDTO patientDTO) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public String getNextId() {
        return "";
    }
}
