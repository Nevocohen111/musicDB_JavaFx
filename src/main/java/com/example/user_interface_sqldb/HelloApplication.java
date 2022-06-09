package com.example.user_interface_sqldb;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class 
HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent fxmlLoader = loader.load();
        HelloController controller = loader.getController();
        controller.listArtists();
        stage.setTitle("Music Database");;
        stage.setScene(new Scene(fxmlLoader,1000,800));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        super.init();
        if(!Datasource.getInstance().open()) {
            System.out.println("FATAL ERROR: Could not establish connection to the database");
            Platform.exit();

        } else {
            Datasource.getInstance().open();
        }


    }

    @Override
    public void stop() throws Exception {
        super.stop();
        Datasource.getInstance().close();
    }
}
