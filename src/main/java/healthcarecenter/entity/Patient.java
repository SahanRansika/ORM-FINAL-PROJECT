package healthcarecenter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "patient")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Patient {
    @Id
    @Column(name = "patient_Id")
    private String colPatientId;
    private String colName;
    private String colAddress;
    private String colGender;
    private String colBirth;
    private String colPhone;
    private String colRDate;
//
//    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL)
//    private List<Sessions> sessions;
//
//    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL)
//    private List<Registration> registration;
}
