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
public class ChildDto {

    private int childId;
    private int motherId;
    private Integer fatherId; // Nullable
    private String name;
    private LocalDate dob;
    private String gender;
    private float birthWeight;
    private String healthIssues;
    private int birthOrder;

}
