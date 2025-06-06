package lk.ijse.m_h_c_system.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.m_h_c_system.model.AuthModel;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {
    public PasswordField txtPassword;
    public TextField txtUserName;

    private static final String USERNAME_PATTERN = "^.+$";
    private static final String PASSWORD_PATTERN = "^[a-zA-Z0-9]{4,8}$";
    public AnchorPane ancLogin;
    private AuthModel authModel = new AuthModel();




    public void btnLoginOnAction(ActionEvent actionEvent) {
        String userName = txtUserName.getText();
        String password = txtPassword.getText();

        boolean isValidUserName = userName.matches(USERNAME_PATTERN);
        boolean isValidPassword = password.matches(PASSWORD_PATTERN);
        if (isValidUserName && isValidPassword) {
            txtUserName.getStyleClass().remove("textField-invalid");
            txtPassword.getStyleClass().remove("textField-invalid");

            try {
                boolean isValid= authModel.login(userName,password);
                if (isValid) {
                    new Alert(Alert.AlertType.INFORMATION, "Login Success").show();
                    loader("/view/DashboardLayout.fxml");
                }else {
                    new Alert(Alert.AlertType.ERROR, "Login Failed").show();
                }
            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR, "Login Failed: "+e.getMessage()).show();
            }
        } else {
            if (!isValidUserName) {
                txtUserName.getStyleClass().add("textField-invalid");
            }else{
                txtUserName.getStyleClass().remove("textField-invalid");
            }
            if (!isValidPassword) {
                txtPassword.getStyleClass().add("textField-invalid");
            }else {
                txtPassword.getStyleClass().remove("textField-invalid");
            }
        }
    }

    public void loader(String path) {
        ancLogin.getChildren().clear();
        try {
            AnchorPane pane = FXMLLoader.load(getClass().getResource(path));
            ancLogin.getChildren().add(pane);

            // Maximize the stage
            Stage stage = (Stage) ancLogin.getScene().getWindow();
//            stage.setMaximized(true);

            pane.prefWidthProperty().bind(ancLogin.widthProperty());
            pane.prefHeightProperty().bind(ancLogin.heightProperty());

        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "Something went wrong loading: " + e.getMessage()).show();
            e.printStackTrace();
        }
    }

}
