package healthcarecenter.dto.tm;

import lombok.*;

@AllArgsConstructor
@Data
public class ProgramTM {
    private String programId;
    private String therapistId;
    private String name;
    private String duration;
    private String cost;
    private String description;
}
