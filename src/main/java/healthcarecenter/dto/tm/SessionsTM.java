package healthcarecenter.dto.tm;

import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SessionsTM {
    private String sessionId;
    private String programId;
    private String therapistId;
    private String patientId;
    private String duration;
    private Date pDate;
    private Date sDate;
    private String phone;
    private String payment;
    private String total;
}
