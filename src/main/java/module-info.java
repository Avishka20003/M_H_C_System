module lk.ijse.m_h_c_system {
    requires javafx.fxml;
    requires java.sql;
    requires static lombok;
    requires com.jfoenix;
    requires javafx.controls;
    requires mysql.connector.j;


    opens lk.ijse.m_h_c_system to javafx.fxml;
    exports lk.ijse.m_h_c_system;
    opens lk.ijse.m_h_c_system.controller to javafx.fxml;
    opens lk.ijse.m_h_c_system.dto.tm to javafx.base;
}