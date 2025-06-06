package lk.ijse.m_h_c_system.dto.tm;

import javafx.scene.layout.HBox;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ClincTm {

    public int clinic_id;
    public String clinic_name;
    public String location;
    public String contact;
    public String status;
    public HBox action;

    public ClincTm(int fatherId, String name, String address, String nic, String email, String phoneNumber, HBox actionBox) {
    }
}
