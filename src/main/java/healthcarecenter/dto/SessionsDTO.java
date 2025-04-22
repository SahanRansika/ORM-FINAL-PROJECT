package healthcarecenter.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SessionsDTO {
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
