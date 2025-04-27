package healthcarecenter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "sessions")
public class Sessions {
    @Id
    @Column(name = "session_Id")
    private String sessionId;

    @ManyToOne
    @JoinColumn(name = "patient_Id", referencedColumnName = "patient_Id")
    private Patient patient;

    private Date sessionDate;


//    private List<Program> programs;
}
