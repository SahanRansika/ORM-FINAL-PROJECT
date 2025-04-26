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
    private String therapistId;
    private String name;
    private String spec;
    private String years;
    private String phone;
    private String assigned;

    public Therapist(String therapistId, String name, String spec, String years, String phone, String assigned) {
        this.therapistId = therapistId;
        this.name = name;
        this.spec = spec;
        this.years = years;
        this.phone = phone;
        this.assigned = assigned;
    }

    @OneToOne(mappedBy = "therapist")
    private Program program;

}
