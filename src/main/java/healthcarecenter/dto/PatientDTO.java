package healthcarecenter.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class PatientDTO {
    private String colPatientId;
    private String colName;
    private String colAddress;
    private String colGender;
    private String colBirth;
    private String colPhone;
    private String colRDate;
}
