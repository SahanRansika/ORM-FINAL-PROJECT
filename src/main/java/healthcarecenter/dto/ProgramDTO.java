package healthcarecenter.dto;

import lombok.*;

@AllArgsConstructor
@Data
public class ProgramDTO {
    private String programId;
    private String therapistId;
    private String name;
    private String duration;
    private String cost;
    private String description;
}
