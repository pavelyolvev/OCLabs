package com.example.lab3simplified;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class HelloController {

    Path rootPath;
    String typeFilter;

    @FXML
    private Button btnApply, btnBrowse, btnFilter;

    @FXML
    private ListView<TVContainer> listView;

    @FXML
    private TextField txtFilter, txtPath;

    @FXML
    void OnClickApply(ActionEvent event) {
        rootPath = Path.of(txtPath.getText()+ "/Root");
        if(rootPath.toFile().exists()){
            openList(typeFilter);
        }
        else{
            if(rootPath.toFile().mkdir()) //////////////////////////////////СОЗДАТЬ КОРНЕВУЮ ДИРЕКТОРИЮ ПРИ ЗАПУСКЕ
            {
                Alert mkDirAler = new Alert(Alert.AlertType.INFORMATION);
                mkDirAler.setHeaderText("Root created in: " + txtPath.getText());
                mkDirAler.showAndWait();
                openList(typeFilter);
            }
        }
        txtPath.setDisable(true);
        txtFilter.setDisable(false);
        btnFilter.setDisable(false);
        btnBrowse.setDisable(true);
        btnApply.setText("Refresh");
        //rootPath = Path.of(txtPath.getText() + "/Root"); //////////////////////////////
        //if(rootPath.toFile().mkdir()) //////////////////////////////////СОЗДАТЬ КОРНЕВУЮ ДИРЕКТОРИЮ ПРИ ЗАПУСКЕ
        //    openList(typeFilter);
        //else System.out.println("Failed to create")


    }

    void openList(String toFilter){
        File[] files = rootPath.toFile().listFiles();
        List<TVContainer> list = new ArrayList<>();

        for (File file: Objects.requireNonNull(files)) {
            if(!Objects.isNull(toFilter) && !toFilter.isEmpty()){
                if(file.getName().endsWith(toFilter) || (toFilter.equals("Folder") && file.getName().equals(file.getName().substring(file.getName().lastIndexOf(".") + 1)))){
                    list.add(new TVContainer(file));
                }
            }
            else list.add(new TVContainer(file));
        }
        listView.setItems(FXCollections.observableList(list));
        UpdateList();


    }
    @FXML
    void OnClickBrowse(ActionEvent event) {
        DirectoryChooser dirChooser = new DirectoryChooser();
        dirChooser.setTitle("Select root folder");

        if(Objects.isNull(rootPath))
            dirChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
        else dirChooser.setInitialDirectory(rootPath.toFile());


        Stage stage = new Stage();
        rootPath = dirChooser.showDialog(stage).toPath();
        txtPath.setText(rootPath.toString());
        OnClickApply(event);
    }

    @FXML
    void OnClickFilter(ActionEvent event) {
        typeFilter = txtFilter.getText();
        openList(typeFilter);
    }

    @FXML
    void UpdateList(){
        listView.refresh();
    }

}
