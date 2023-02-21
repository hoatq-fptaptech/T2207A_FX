package controllers;

import daopattern.ClassesDAO;
import database.Database;
import entities.Classes;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.Statement;

public class CreateClassController {
    public TextField txtName;
    public TextField txtRoom;

    public void goToClassList(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../resources/classes/list.fxml"));
        HomeController.rootStage.setScene(new Scene(root,600,400));
    }

    public void submit(ActionEvent event) {
        try{
            String name = txtName.getText();
            String room = txtRoom.getText();
            if(name.isEmpty() || room.isEmpty()){
                throw new Exception("Vui lòng điền đẩy đủ thông tin");
            }

            Classes c = new Classes(null,name,room);
            ClassesDAO cd = ClassesDAO.getInstance();
            if(cd.create(c))
                goToClassList(null);
            else
                throw new Exception("Không thể tạo lớp học");
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(e.getMessage());
            alert.show();
        }
    }
}
// 1 sinh vien: id, name, email, ngay sinh, gioi tinh, lop hoc id