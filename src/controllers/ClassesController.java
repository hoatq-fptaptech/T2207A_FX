package controllers;

import database.Database;
import entities.Classes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ClassesController implements Initializable {
    public TableView<Classes> tbClasses;
    public TableColumn<Classes,Integer> cId;
    public TableColumn<Classes,String> cName;
    public TableColumn<Classes,String> cRoom;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cId.setCellValueFactory(new PropertyValueFactory<>("id"));
        cName.setCellValueFactory(new PropertyValueFactory<>("name"));
        cRoom.setCellValueFactory(new PropertyValueFactory<>("room"));
        ObservableList<Classes> list = FXCollections.observableArrayList();
        try {
            Database db = Database.getInstance();
            Statement stt = db.getStatement();
            String sql = "select * from lophoc";
            ResultSet rs = stt.executeQuery(sql);
            while (rs.next()){
               Integer id = rs.getInt("id");
               String name = rs.getString("name");
               String room = rs.getString("room");
               Classes c = new Classes(id,name,room);
               list.add(c);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        tbClasses.setItems(list);
    }

    public void goToHome(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../resources/home.fxml"));
        HomeController.rootStage.setScene(new Scene(root,600,400));
    }

    public void goToCreate(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../resources/classes/create.fxml"));
        HomeController.rootStage.setScene(new Scene(root,600,400));
    }
}
