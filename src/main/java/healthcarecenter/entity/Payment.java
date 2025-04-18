package healthcarecenter.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Payment {
    private String colPaymentId;
    private String colRId;
    private String colSessionId;
    private String colPayDate;
    private String colAmount;
}
