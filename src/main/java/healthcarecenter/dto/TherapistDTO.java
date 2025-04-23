package healthcarecenter.dto;

import lombok.*;

@AllArgsConstructor
@Data
public class TherapistDTO {
    private String therapistId;
    private String name;
    private String spec;
    private String years;
    private String phone;
    private String assigned;
}
