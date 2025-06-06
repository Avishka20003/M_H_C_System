package lk.ijse.m_h_c_system.model;

import lk.ijse.m_h_c_system.Util.CrudUtil;
import lk.ijse.m_h_c_system.dto.FamilyDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FamilyModel {
    public ArrayList<FamilyDto> familyList() throws SQLException, ClassNotFoundException {
        ArrayList<FamilyDto> familyList = new ArrayList<>();
        ResultSet result = CrudUtil.execute("select * from family");

        while (result.next()) {
            FamilyDto family = new FamilyDto(
                    result.getInt(1),
                    result.getInt(2),
                    result.getInt(3),
                    result.getInt(4),
                    result.getString(5),
                    result.getString(6)
            );
            familyList.add(family);
        }
        return familyList;
    }

}
