package lk.ijse.m_h_c_system.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class FatherDto {

    private int fatherId;
    private String name;
    private String nic;
    private String contactNumber;
    private String email;
    private String occupation;

}
