package com.example.lab3simplified;

import javafx.scene.control.TreeItem;

import java.io.File;


public class TVContainer extends TreeItem<File> {

    private final File file;

    public TVContainer(File file){
        this.file = file;
    }
    @Override
    public String toString(){

        return file.getName();
    }

    public File getFile(){
        return file;
    }
}
