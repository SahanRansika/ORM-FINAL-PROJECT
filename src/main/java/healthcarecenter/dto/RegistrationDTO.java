package healthcarecenter.dto;

import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@Data
public class RegistrationDTO {
    private String registrationId;
    private String patientId;
    private String programId;
    private Date registrationDate;



}
