package healthcarecenter.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaymentDTO {
    private String colPaymentId;
    private String colRId;
    private String colSessionId;
    private String colPayDate;
    private String colAmount;
}
