package healthcarecenter.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "patient")
@NoArgsConstructor
@Data

public class Patient {
    @Id
    @Column(name = "patient_Id")
    private String patientId;
    private String name;
    private String address;
    private String gender;
    private String birth;
    private String phone;
    private Date registrationDate;

    public Patient(String patientId, String name, String address, String gender, String birth, String phone, Date registrationDate) {
        this.patientId = patientId;
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.birth = birth;
        this.phone = phone;
        this.registrationDate = registrationDate;
    }


    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL)
    private List<Sessions> sessions;

    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL)
    private List<Registration> registration;
}
