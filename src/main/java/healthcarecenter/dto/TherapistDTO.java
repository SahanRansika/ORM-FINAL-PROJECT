package healthcarecenter.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TherapistDTO {
    private String colTherapistId;
    private String colName;
    private String colSpec;
    private String colYears;
    private String colPhone;
    private String colAssigned;
}
