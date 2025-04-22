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
    private String colSessionId;
    private String colProgramId;
    private String colTherapistId;
    private String colPatientId;
    private String colDuration;
    private String colPDate;
    private String colSDate;
    private String colPhone;
    private String colPayment;
    private String colTotal;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Program program;

    @ManyToOne
    private Therapist therapist;

    @OneToOne
    private Payment payment;

}
