package lk.ijse.m_h_c_system.dto.tm;

import com.jfoenix.controls.JFXButton;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class SessionTm {
    public int session_id;
    public String topic;
    public String description;
    public String date;
    public String duration;
    private JFXButton action;

}
