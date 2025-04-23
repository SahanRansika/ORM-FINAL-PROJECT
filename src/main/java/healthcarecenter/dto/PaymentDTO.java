package healthcarecenter.dto;

import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@Data
public class PaymentDTO {
    private String paymentId;
    private String rId;
    private String sessionId;
    private Date payDate;
    private String amount;
}
