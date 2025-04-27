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
    private String name;
    private String duration;
    private String cost;
    private String description;

    @OneToOne
    private Therapist therapist;

    @OneToMany(mappedBy = "program",cascade = CascadeType.ALL)
    private List<Registration> registration;
}
