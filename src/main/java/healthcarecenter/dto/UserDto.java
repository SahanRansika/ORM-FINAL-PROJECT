package healthcarecenter.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto {
    private String role;

    private String phoneNumber;

    private String userName;

    private String password;
}
