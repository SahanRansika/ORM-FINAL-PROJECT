package healthcarecenter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "program")
public class Program {
    @Id
    @Column(name = "program_Id")
    private String colProgramedId;
    private String colTherapistId;
    private String colName;
    private String colDuration;
    private String colCost;
    private String colDesc;

    @OneToMany(mappedBy = "program",cascade = CascadeType.ALL)
    private List<Sessions> sessions;

    @OneToOne
    private Therapist therapist;

    @OneToMany(mappedBy = "program",cascade = CascadeType.ALL)
    private List<Registration> registration;
}
