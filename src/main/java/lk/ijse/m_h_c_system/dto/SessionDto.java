package lk.ijse.m_h_c_system.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class SessionDto {
    int session_id;
    String topic;
    String description;
    String duration;
    int midwife_id;
    String date;

    public SessionDto(String topic, String description, String date, String duration, int midwife_id) {
        this.topic = topic;
        this.description = description;
        this.date = date;
        this.duration = duration;
        this.midwife_id = midwife_id;
    }

}

