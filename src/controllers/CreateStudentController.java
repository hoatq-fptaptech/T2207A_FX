package controllers;

import daopattern.ClassesDAO;
import database.Database;
import entities.Classes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CreateStudentController implements Initializable {

    public TextField txtName;
    public TextField txtEmail;
    public DatePicker txtBirthday;
    public ComboBox<String> cbGender;
    public ComboBox<Classes> cbClass;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> gt = FXCollections.observableArrayList();
        gt.add("Male");
        gt.add("Female");
        cbGender.setItems(gt);

        try {
            ClassesDAO cd = ClassesDAO.getInstance();
            ArrayList<Classes> ls = cd.getAll();
            cbClass.getItems().addAll(ls);
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(e.getMessage());
            alert.show();
        }

    }

    public void submit(ActionEvent event) {
        String name = txtName.getText();
        String email = txtEmail.getText();
        String birthday = Date.valueOf(txtBirthday.getValue()).toString();
        String gender = cbGender.getValue();
        Integer class_id = cbClass.getValue().getId();
    }
}
