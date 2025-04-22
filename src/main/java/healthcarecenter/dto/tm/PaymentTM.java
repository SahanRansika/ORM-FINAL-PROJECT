package healthcarecenter.dto.tm;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaymentTM {
    private String colPaymentId;
    private String colRId;
    private String colSessionId;
    private String colPayDate;
    private String colAmount;
}
