package healthcarecenter.dto;

import healthcarecenter.entity.Patient;
import lombok.*;

import java.sql.Date;
import java.util.List;


@AllArgsConstructor
@Data
public class SessionsDTO {
    private String sessionId;
    private String patientId;
    private Date sessionDate;
//    private List<ProgramDTO> programDTOS;
}
