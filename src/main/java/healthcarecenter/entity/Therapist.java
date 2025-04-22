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
@Table(name = "therapist")
public class Therapist {
    @Id
    @Column(name = "therapist_Id")
    private String colTherapistId;
    private String colName;
    private String colSpec;
    private String colYears;
    private String colPhone;
    private String colAssigned;

    @OneToMany(mappedBy = "therapist",cascade = CascadeType.ALL)
    private List<Sessions> sessions;

    @OneToOne(mappedBy = "therapist")
    private Program program;
}
