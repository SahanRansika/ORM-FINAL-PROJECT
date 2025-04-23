package healthcarecenter.dto;

import lombok.*;

import java.sql.Date;
@AllArgsConstructor
@Data
public class PatientDTO {
    private String patientId;
    private String name;
    private String address;
    private String gender;
    private String birth;
    private String phone;
    private Date registrationDate;

}
