package healthcarecenter.dto.tm;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PatientTM {
    private String colPatientId;
    private String colName;
    private String colAddress;
    private String colGender;
    private String colBirth;
    private String colPhone;
    private String colRDate;
}
