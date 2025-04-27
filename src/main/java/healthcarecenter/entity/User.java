package healthcarecenter.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "user")
public class User {
    @Column(nullable = false)
    private String role;

    @Column(name = "phone_number" ,nullable = false)
    private String phoneNumber;

    @Id
    @Column (name = "user_name")
    private String userName;

    @Column(nullable = false)
    private String password;

//    public User(String name, String role, String phoneNumber, String address, String userName, String password) {
//        this.name = name;
//        this.role = role;
//        this.phoneNumber = phoneNumber;
//        this.address = address;
//        this.userName = userName;
//        this.password = password;
//    }
}
