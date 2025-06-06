package lk.ijse.m_h_c_system.model;


import lk.ijse.m_h_c_system.Util.CrudUtil;
import lk.ijse.m_h_c_system.dto.FamilyDto;
import lk.ijse.m_h_c_system.dto.FatherDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FatherModel {

    public boolean addFather(FatherDto father) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO father (name, address, nic, dob, occupation, email, phone_number, blood_type) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        return CrudUtil.execute(sql,
                father.getName(),
                father.getAddress(),
                father.getNic(),
                father.getDob(),
                father.getOccupation(),
                father.getEmail(),
                father.getPhone_number(),
                father.getBlood_type()
        );
    }

    public boolean updateFather(FatherDto father) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE father SET name=?, address=?, nic=?, dob=?, occupation=?, email=?, phone_number=?, blood_type=? " +
                "WHERE father_id=?";
        return CrudUtil.execute(sql,
                father.getName(),
                father.getAddress(),
                father.getNic(),
                father.getDob(),
                father.getOccupation(),
                father.getEmail(),
                father.getPhone_number(),
                father.getBlood_type(),
                father.getFather_id()
        );
    }

    public boolean deleteFather(int fatherId) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM father WHERE father_id=?";
        return CrudUtil.execute(sql, fatherId);
    }

    public ArrayList<FatherDto> getAllFathers() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM father";
        ResultSet resultSet = CrudUtil.execute(sql);
        ArrayList<FatherDto> fatherList = new ArrayList<>();

        while (resultSet.next()) {
            FatherDto father = new FatherDto(
                    resultSet.getInt("father_id"),
                    resultSet.getString("name"),
                    resultSet.getString("address"),
                    resultSet.getString("nic"),
                    resultSet.getString("dob"),
                    resultSet.getString("occupation"),
                    resultSet.getString("email"),
                    resultSet.getString("phone_number"),
                    resultSet.getString("blood_type")
            );
            fatherList.add(father);
        }

        return fatherList;
    }
    public ArrayList<String> getAllFatherId( ) throws SQLException, ClassNotFoundException {
        ArrayList<String> fatherList = new ArrayList<>();
        ResultSet resultSet = CrudUtil.execute("select * from father");
        while (resultSet.next()) {
            fatherList.add(resultSet.getString("father_id"));
        }

        return fatherList;



    }
}
