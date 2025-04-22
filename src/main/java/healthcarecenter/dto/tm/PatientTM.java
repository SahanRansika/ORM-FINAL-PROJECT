package healthcarecenter.dto.tm;

import lombok.*;

import java.util.Date;

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
    private Date colRDate;
}
