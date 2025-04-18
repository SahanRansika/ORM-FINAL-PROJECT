package healthcarecenter.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Therapist {
    private String colTherapistId;
    private String colName;
    private String colSpec;
    private String colYears;
    private String colPhone;
    private String colAssigned;
}
