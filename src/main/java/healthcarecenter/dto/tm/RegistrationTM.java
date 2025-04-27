package healthcarecenter.dto.tm;

import lombok.*;

import java.sql.Date;
@AllArgsConstructor
@Data
public class RegistrationTM {
    private String registrationId;
    private String patientId;
    private String programId;
    private Date registrationDate;
}
