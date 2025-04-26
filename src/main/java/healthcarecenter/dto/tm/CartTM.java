package healthcarecenter.dto.tm;

import javafx.scene.control.Button;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CartTM {
    private String programId;
    private String programName;
    private String payment;
    private String total;
    private Button removeBtn;
}
