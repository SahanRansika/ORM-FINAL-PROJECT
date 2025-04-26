package healthcarecenter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "sessions")
public class Sessions {
    @Id
    @Column(name = "Session_Id")
    private String sessionId;
    private String patientId;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Program program;




}
