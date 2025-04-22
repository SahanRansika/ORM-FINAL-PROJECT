package healthcarecenter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "registration")
public class Registration {
    @Id
    @Column(name = "R_Id")
    private String colRId;
    private String colPatientId;
    private String colProgramId;
    private String colDate;

    @ManyToOne
    private Payment payment;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Program program;
}
