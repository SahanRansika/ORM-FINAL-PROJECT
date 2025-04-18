package healthcarecenter.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProgramDTO {
    private String colProgramedId;
    private String colTherapistId;
    private String colName;
    private String colDuration;
    private String colCost;
    private String colDesc;
}
