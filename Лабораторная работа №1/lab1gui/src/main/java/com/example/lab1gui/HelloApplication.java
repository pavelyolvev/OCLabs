package com.example.lab1gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.application.Platform;

import java.io.IOException;
import java.util.Random;
import java.util.random.*;

import com.example.lab1gui.TankNCup.*;
import com.example.lab1gui.MyThread.*;
//import com.example.lab1gui.HelloController;

public class HelloApplication extends Application {
    Tank tank = new Tank(1000);
    Tank tank2 = new Tank(1000);
    Tank tank3 = new Tank(1000);
    Cup cup =new Cup();
    private int volume = 0;
HelloController controller = new HelloController();
    ProgressBar progressBar = new ProgressBar(1000);
    public void updateProgressBar(int cupInd){
        volume += cup.getElem(cupInd);
        progressBar.setProgress(volume);
    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 239);
        //StackPane root = new StackPane();
        //root.getChildren().add(progressBar);
        //progressBar.setProgress(0);

        //Scene scene = new Scene(root, 200, 200);

        /*
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                Runnable updater = new Runnable() {

                    @Override
                    public void run() {
                        updateProgressBar(0);
                    }
                };

                while (true) {
                    try {
                        Thread.sleep(1000);
                        cup.antisort();
                    }
                    catch (InterruptedException ex) {
                    }

                    // UI update is run on the Application thread
                    Platform.runLater(updater);
                }
            }

        });
        thread.setDaemon(true);
        thread.start();
*/
        stage.setTitle("Hello!");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

