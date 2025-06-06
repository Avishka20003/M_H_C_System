package lk.ijse.m_h_c_system.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ChildDto {
    private int child_id;
    private String mother_id;
    private String father_id;
    private String name;
    private String address;
    private String birth_place;
    private String gender;
    private String dob;
    private float birth_height;
    private float birth_weight;
    private String note;
    private String blood_type;

    public ChildDto(String name,String address,String birth_place,String gender,String dob,
                    float birth_height,float birth_weight,String note,String blood_type){
        this.name=name;
        this.address=address;
        this.birth_place=birth_place;
        this.gender=gender;
        this.dob=dob;
        this.birth_height=birth_height;
        this.birth_weight=birth_weight;
        this.note=note;
        this.blood_type=blood_type;


    }


}
