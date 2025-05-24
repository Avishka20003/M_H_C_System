package lk.ijse.m_h_c_system.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.m_h_c_system.dto.SessionDto;
import lk.ijse.m_h_c_system.dto.tm.SessionTm;
import lk.ijse.m_h_c_system.model.SesstionModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class SessionController implements Initializable {

    public TableColumn<SessionTm, Integer> collId;
    public TableColumn<SessionTm, String> collTopic;
    public TableColumn<SessionTm, String> collDessc;
    public TableColumn<SessionTm, String> collDate;
    public TableColumn<SessionTm, String> collDuration;

    public TableColumn collAction;
    public TextField txtTopic;
    public TextField txtDdscription;
    public TextField txtDate;
    public TextField txtDuration;
    public TableView tblSesstions;


    SesstionModel sesstionModel = new SesstionModel();   //  creat an intance of sesstionmodel


    public void btnSaveOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String topic = txtTopic.getText();
        String description = txtDdscription.getText();
        String date = txtDate.getText();
        String duration = txtDuration.getText();

        SessionDto session = new SessionDto(topic, description, date, duration, 1);


        try {
            boolean isAdd = sesstionModel.addSession(session);
            if (isAdd) {
                new Alert(Alert.AlertType.CONFIRMATION, "Session added successfully").show();
                reset();
            } else {
                new Alert(Alert.AlertType.CONFIRMATION, "Session added error").show();
            }

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Something went wrong").show();
            e.printStackTrace();

        }
    }

    private void reset() throws SQLException, ClassNotFoundException {
        loadSession();
        txtTopic.clear();
        txtDdscription.clear();
        txtDate.clear();
        txtDuration.clear();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeTable();
        try {
            reset();

        }catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            e.printStackTrace();
        }

    }

    public void initializeTable() {
        collId.setCellValueFactory(new PropertyValueFactory<>("session_id"));
        collTopic.setCellValueFactory(new PropertyValueFactory<>("topic"));
        collDessc.setCellValueFactory(new PropertyValueFactory<>("description"));
        collDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        collDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        collAction.setCellValueFactory(new PropertyValueFactory<>("action"));

    }

    public void loadSession() throws SQLException, ClassNotFoundException {
        ArrayList<SessionDto> session = sesstionModel.getAllSession();
        ObservableList<SessionTm> observableList = FXCollections.observableArrayList();
        for (SessionDto sessionDto : session) {
            SessionTm sessionTm = new SessionTm();
            sessionTm.setSession_id(sessionDto.getSession_id());
            sessionTm.setTopic(sessionDto.getTopic());
            sessionTm.setDescription(sessionDto.getDescription());
            sessionTm.setDate(sessionDto.getDate());
            sessionTm.setDuration(sessionDto.getDuration());

            JFXButton btnDelete = new JFXButton("Delete");
            btnDelete.setOnAction(event -> {
                try {
                    deleteSession(sessionDto.getSession_id());
                } catch (Exception e) {
                    new Alert(Alert.AlertType.ERROR, "Something went wrong").show();
                }
            });

            sessionTm.setAction(btnDelete);
            observableList.add(sessionTm);

        }
        tblSesstions.setItems(observableList);

    }
    public void deleteSession(int id) throws SQLException, ClassNotFoundException {

        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Session");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to delete this session?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    boolean isDeleted = sesstionModel.deleteSession(id);

                    if (isDeleted) {
                        System.out.println("Deleted session successfully");
                        reset();
                    }else {
                        new Alert(Alert.AlertType.ERROR, "Something went wrong").show();
                    }
                }
        }catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            e.printStackTrace();
        }

    }
}