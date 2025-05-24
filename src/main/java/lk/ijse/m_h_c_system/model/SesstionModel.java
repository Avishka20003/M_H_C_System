package lk.ijse.m_h_c_system.model;

import lk.ijse.m_h_c_system.Util.CrudUtil;
import lk.ijse.m_h_c_system.dto.SessionDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SesstionModel {

    public boolean addSession(SessionDto sessionDto) throws SQLException, ClassNotFoundException {
        boolean isAdded = CrudUtil.execute(
                "INSERT INTO session(topic, description, date, duration, midwife_id) VALUES(?,?,?,?,?)",
                sessionDto.getTopic(),
                sessionDto.getDescription(),
                sessionDto.getDate(),
                sessionDto.getDuration(),
                1
        );
       return isAdded;
    }
    public ArrayList<SessionDto> getAllSession() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.execute("SELECT * FROM session");
        ArrayList<SessionDto> sessions = new ArrayList<>();
        while (result.next()) {
            SessionDto session = new SessionDto(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),result.getInt(5),result.getString(6));
            sessions.add(session);

        }
        return sessions;
    }
    public boolean deleteSession(int id) throws SQLException, ClassNotFoundException {
        boolean isDeleted = CrudUtil.execute("DELETE FROM session WHERE session_id = ? ", id);
        return isDeleted;
    }
}
