package healthcarecenter.dto;

import lombok.*;

@AllArgsConstructor
@Data
public class PaymentDTO {
    private String sessionId;
    private String programId;
    private double payment;
}
