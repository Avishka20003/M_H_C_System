package lk.ijse.m_h_c_system.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FamilyDto {
    private  int family_id;
    private int mother_id;
    private int father_id;
    private int midwife_if;
    private String contact;
    private String regDate;
}
