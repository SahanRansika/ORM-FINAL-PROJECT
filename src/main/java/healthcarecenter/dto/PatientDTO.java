package healthcarecenter.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class PatientDTO {
    private String patientId;
    private String name;
    private String address;
    private String gender;
    private String birth;
    private String phone;
    private Date rDate;
}
