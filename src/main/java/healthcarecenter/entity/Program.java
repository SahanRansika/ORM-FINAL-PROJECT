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
    private String programId;
    private String therapistId;
    private String name;
    private String duration;
    private String cost;
    private String description;

    public Program(String programId, String therapistId, String name, String duration, String cost, String description) {
        this.programId = programId;
        this.therapistId = therapistId;
        this.name = name;
        this.duration = duration;
        this.cost = cost;
        this.description = description;
    }

    @OneToMany(mappedBy = "program",cascade = CascadeType.ALL)
    private List<Sessions> sessions;

    @OneToOne
    private Therapist therapist;

    @OneToMany(mappedBy = "program",cascade = CascadeType.ALL)
    private List<Registration> registration;

}
