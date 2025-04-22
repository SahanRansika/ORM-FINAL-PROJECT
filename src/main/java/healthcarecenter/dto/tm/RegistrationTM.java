package healthcarecenter.dto.tm;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegistrationTM {
    private String colRId;
    private String colPatientId;
    private String colProgramId;
    private String colDate;
}
