package healthcarecenter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "registration")
public class Registration {
    @Id
    @Column(name = "R_Id")
    private String registrationId;
    private String patientId;
    private String programId;
    private Date registrationDate;

    public Registration(String registrationId, String patientId, String programId, Date registrationDate) {
        this.registrationId = registrationId;
        this.patientId = patientId;
        this.programId = programId;
        this.registrationDate = registrationDate;
    }


    @ManyToOne
    private Payment payments;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Program program;

}
