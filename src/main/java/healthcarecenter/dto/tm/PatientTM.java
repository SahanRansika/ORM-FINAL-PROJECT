package healthcarecenter.dto.tm;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@Data
public class PatientTM {
    private String patientId;
    private String name;
    private String address;
    private String gender;
    private String birth;
    private String phone;
    private Date registrationDate;
}
