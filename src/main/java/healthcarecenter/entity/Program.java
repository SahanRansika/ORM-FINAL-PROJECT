package healthcarecenter.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Program {
    private String colProgramedId;
    private String colTherapistId;
    private String colName;
    private String colDuration;
    private String colCost;
    private String colDesc;
}
