package healthcarecenter.dto.tm;

import lombok.*;

import java.sql.Date;

@Data
public class RegistrationTM {
    private String registrationId;
    private String patientId;
    private String programId;
    private Date registrationDate;

    public RegistrationTM(String registrationId, String patientId, String programId, Date registrationDate) {
    }
}
