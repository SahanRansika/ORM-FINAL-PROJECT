package healthcarecenter.dto.tm;

import lombok.*;

@AllArgsConstructor
@Data
public class TherapistTM {
    private String therapistId;
    private String name;
    private String spec;
    private String years;
    private String phone;
    private String assigned;
}
