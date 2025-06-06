package lk.ijse.m_h_c_system.model;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import lk.ijse.m_h_c_system.Util.CrudUtil;
import lk.ijse.m_h_c_system.dto.ClinicDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClinicModel {
    public boolean addClinic(ClinicDto clinic) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO clinic (clinic_name,location,description,contact) VALUES (?,?,?,?)";
        boolean isInsert = CrudUtil.execute(sql, clinic.getClinic_name(), clinic.getClinic_location(), clinic.getDescription(), clinic.getContact());
        return isInsert;
    }

    public boolean DeleteClinic(String clinicId) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM clinic WHERE clinic_id=?";
        boolean isDelete = CrudUtil.execute(sql,clinicId);
        return isDelete;
    }

    public ArrayList<ClinicDto> getAllClinic() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM clinic";
        ResultSet resultSet = CrudUtil.execute(sql);
        ArrayList<ClinicDto> clinicDtos = new ArrayList<>();
        while (resultSet.next()) {
            ClinicDto clinicDto = new ClinicDto(
                    resultSet.getInt("clinic_id"),
                    resultSet.getString("clinic_name"),
                    resultSet.getString("location"),
                    resultSet.getString("description"),
                    resultSet.getString("contact"),
                    resultSet.getString("status")

            );
            clinicDtos.add(clinicDto);

        }
        return clinicDtos;
    }

    public boolean update(ClinicDto clinicDto) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE clinic SET clinic_name=?,location=?,description=?,contact=? WHERE clinic_id=?";
        boolean isUpdated = CrudUtil.execute(sql , clinicDto.getClinic_name(),clinicDto.getClinic_location(),clinicDto.getDescription(),clinicDto.getContact(),clinicDto.getClinic_id());
        return isUpdated;
    }
}
