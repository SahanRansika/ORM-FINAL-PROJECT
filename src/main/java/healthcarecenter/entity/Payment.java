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
@Table(name = "payments")
public class Payment {
    @Id
    @Column(name = "payment_Id")
    private String paymentId;
    private String registrationId;
    private String sessionId;
    private String payDate;
    private String amount;

    @OneToMany(mappedBy = "payments",cascade = CascadeType.ALL)
    private List<Sessions> sessions;


    @OneToMany(mappedBy = "payments",cascade = CascadeType.ALL)
    private List<Registration> registration;
}
