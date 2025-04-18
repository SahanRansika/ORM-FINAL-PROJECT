package healthcarecenter.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Registration {
    private String colRId;
    private String colPatientId;
    private String colProgramId;
    private String colDate;
}
