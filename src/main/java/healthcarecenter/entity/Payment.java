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
@Table(name = "payment")
public class Payment {
    @Id
    @Column(name = "payment_Id")
    private String colPaymentId;
    private String colRId;
    private String colSessionId;
    private String colPayDate;
    private String colAmount;

    @OneToOne(mappedBy = "payment")
    private Sessions sessions;

    @OneToMany(mappedBy = "payment",cascade = CascadeType.ALL)
    private List<Registration> registration;
}
