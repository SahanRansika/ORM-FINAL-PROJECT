package healthcarecenter.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@Data
public class SessionsDTO {
    private String sessionId;
    private String patientId;
    private List<PaymentDTO> paymentDTOS;
}
