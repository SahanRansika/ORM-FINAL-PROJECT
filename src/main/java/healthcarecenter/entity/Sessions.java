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
    private String programId;
    private String therapistId;
    private String patientId;
    private String duration;
    private String pDate;
    private String sDate;
    private String phone;
    private String payment;
    private String total;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Program program;

    @ManyToOne
    private Therapist therapist;

    @ManyToOne
    private Payment payments;


}
