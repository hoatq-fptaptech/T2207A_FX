package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CreateClassController {
    public void goToClassList(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../resources/classes/list.fxml"));
        HomeController.rootStage.setScene(new Scene(root,600,400));
    }
}
// 1 sinh vien: id, name, email, ngay sinh, gioi tinh, lop hoc id