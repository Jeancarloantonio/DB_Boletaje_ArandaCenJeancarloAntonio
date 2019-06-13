package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.Connection;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        //GridPane grid = new GridPane();
        primaryStage.setTitle("DB Boletaje");
        //grid.setAlignment(Pos.CENTER);
        //grid.setStyle("fx-background-color: #BEEFF3;");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();


        //DBManager db = new DBManager();


    }

    public static void main(String[] args) {
        launch(args);
    }
}
