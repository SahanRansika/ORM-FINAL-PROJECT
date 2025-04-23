package healthcarecenter.dto.tm;

import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@Data
public class PaymentTM {
    private String paymentId;
    private String rId;
    private String sessionId;
    private Date payDate;
    private String amount;
}
