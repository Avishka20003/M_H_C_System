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
        ResultSet resultSet = CrudUtil.execute("SELECT * FROM session");
        ArrayList<SessionDto> sessions = new ArrayList<>();
        while (resultSet.next()) {
            SessionDto session = new SessionDto(
                    resultSet.getInt("session_id"),
                    resultSet.getString("topic"),
                    resultSet.getString("description"),
                    resultSet.getString("date"),
                    resultSet.getString("duration"),
                    resultSet.getInt("midwife_id")
            );
            sessions.add(session);
        }
        return sessions;
    }

    public boolean deleteSession(int sessionId) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM session WHERE session_id=?";
        boolean isDelete = CrudUtil.execute(sql,sessionId);
        return isDelete;
    }

    public boolean updateSession(SessionDto sessionDto) throws SQLException, ClassNotFoundException {
        String sql =  "UPDATE session SET topic=?,description=?,date=?,duration=? WHERE session_id=?";
        boolean isUpdated = CrudUtil.execute(sql ,sessionDto.getTopic(),sessionDto.getDescription(),sessionDto.getDate(),sessionDto.getDuration(),sessionDto.getSession_id());
        return isUpdated;
    }
}