package lk.ijse.m_h_c_system.model;

import lk.ijse.m_h_c_system.Util.CrudUtil;
import lk.ijse.m_h_c_system.dto.MotherDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MotherModel {

    public boolean saveMother(MotherDto mother) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO mother (name, address, nic, dob, occupation, email, phone_number, weight, height, allergies, medical_history, note, blood_type) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return CrudUtil.execute(sql,
                mother.getName(),
                mother.getAddress(),
                mother.getNic(),
                mother.getDob(),
                mother.getOccupation(),
                mother.getEmail(),
                mother.getPhone_number(),
                mother.getWeight(),
                mother.getHeight(),
                mother.getAllergies(),
                mother.getMedical_history(),
                mother.getNote(),
                mother.getBlood_type()
        );
    }

    public boolean updateMother(MotherDto mother) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE mother SET name=?, address=?, nic=?, dob=?, occupation=?, email=?, phone_number=?, weight=?, height=?, allergies=?, medical_history=?, note=?, blood_type=? " +
                "WHERE mother_id=?";
        return CrudUtil.execute(sql,
                mother.getName(),
                mother.getAddress(),
                mother.getNic(),
                mother.getDob(),
                mother.getOccupation(),
                mother.getEmail(),
                mother.getPhone_number(),
                mother.getWeight(),
                mother.getHeight(),
                mother.getAllergies(),
                mother.getMedical_history(),
                mother.getNote(),
                mother.getBlood_type(),
                mother.getMother_id()
        );
    }

    public boolean deleteMother(int motherId) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM mother WHERE mother_id=?";
        return CrudUtil.execute(sql, motherId);
    }

    public ArrayList<MotherDto> getAllMothers() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM mother";
        ResultSet resultSet = CrudUtil.execute(sql);
        ArrayList<MotherDto> motherList = new ArrayList<>();

        while (resultSet.next()) {
            MotherDto mother = new MotherDto(
                    resultSet.getInt("mother_id"),
                    resultSet.getString("name"),
                    resultSet.getString("address"),
                    resultSet.getString("nic"),
                    resultSet.getString("dob"),
                    resultSet.getString("occupation"),
                    resultSet.getString("email"),
                    resultSet.getString("phone_number"),
                    resultSet.getInt("weight"),
                    resultSet.getInt("height"),
                    resultSet.getString("allergies"),
                    resultSet.getString("medical_history"),
                    resultSet.getString("note"),
                    resultSet.getString("blood_type")
            );
            motherList.add(mother);
        }

        return motherList;
    }
}
