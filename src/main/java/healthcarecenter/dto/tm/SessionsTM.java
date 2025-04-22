package healthcarecenter.dto.tm;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SessionsTM {
    private String colSessionId;
    private String colProgramId;
    private String colTherapistId;
    private String colPatientId;
    private String colDuration;
    private String colPDate;
    private String colSDate;
    private String colPhone;
    private String colPayment;
    private String colTotal;
}
