package lk.ijse.m_h_c_system.dto.tm;


import javafx.scene.layout.HBox;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class MotherTm {
    public int mother_id;
    public String name;
    public String address;
    public String nic;
    public String email;
    public String phone_number;
    public HBox action;


}
