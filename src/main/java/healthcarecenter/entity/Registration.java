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
    private Date registrationDate;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Program program;



}
