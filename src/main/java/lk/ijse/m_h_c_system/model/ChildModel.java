package lk.ijse.m_h_c_system.model;

import lk.ijse.m_h_c_system.Util.CrudUtil;
import lk.ijse.m_h_c_system.dto.ChildDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ChildModel {

    public boolean addChild(ChildDto child) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO child (mother_id, father_id, name, address, birth_place, gender, dob, birth_height, birth_weight, note, blood_type) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return CrudUtil.execute(sql,
                child.getMother_id(),
                child.getFather_id(),
                child.getName(),
                child.getAddress(),
                child.getBirth_place(),
                child.getGender(),
                child.getDob(),
                child.getBirth_height(),
                child.getBirth_weight(),
                child.getNote(),
                child.getBlood_type()
        );
    }

    public boolean updateChild(ChildDto child) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE child SET mother_id=?, father_id=?, name=?, address=?, birth_place=?, gender=?, dob=?, birth_height=?, birth_weight=?, note=?, blood_type=? " +
                "WHERE child_id=?";
        return CrudUtil.execute(sql,
                child.getMother_id(),
                child.getFather_id(),
                child.getName(),
                child.getAddress(),
                child.getBirth_place(),
                child.getGender(),
                child.getDob(),
                child.getBirth_height(),
                child.getBirth_weight(),
                child.getNote(),
                child.getBlood_type(),
                child.getChild_id()
        );
    }

    public boolean deleteChild(int childId) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM child WHERE child_id=?";
        return CrudUtil.execute(sql, childId);
    }

    public ArrayList<ChildDto> getAllChildren() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM child";
        ResultSet resultSet = CrudUtil.execute(sql);
        ArrayList<ChildDto> childList = new ArrayList<>();

        while (resultSet.next()) {
            ChildDto child = new ChildDto(
                    resultSet.getInt("child_id"),
                    resultSet.getString("mother_id"),
                    resultSet.getString("father_id"),
                    resultSet.getString("name"),
                    resultSet.getString("address"),
                    resultSet.getString("birth_place"),
                    resultSet.getString("gender"),
                    resultSet.getString("dob"),
                    resultSet.getFloat("birth_height"),
                    resultSet.getFloat("birth_weight"),
                    resultSet.getString("note"),
                    resultSet.getString("blood_type")
            );
            childList.add(child);
        }

        return childList;
    }
}
