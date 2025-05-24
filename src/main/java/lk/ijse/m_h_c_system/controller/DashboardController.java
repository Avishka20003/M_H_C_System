package lk.ijse.m_h_c_system.controller;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController  implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (int i = 0; i < 10; i++) {
            System.out.println("round : "+i);

        }
    }
}
