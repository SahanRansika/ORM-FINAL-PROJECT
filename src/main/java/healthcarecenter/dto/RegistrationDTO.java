package healthcarecenter.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegistrationDTO {
    private String colRId;
    private String colPatientId;
    private String colProgramId;
    private String colDate;
}
