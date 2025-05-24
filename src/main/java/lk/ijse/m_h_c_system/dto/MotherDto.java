package lk.ijse.m_h_c_system.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter


public class MotherDto {

    private int motherId;
    private String name;
    private String nic;
    private LocalDate dob;
    private String contactNumber;
    private String email;
    private String occupation;
    private String address;
    private String medicalHistory;
    private String bloodType;
}


