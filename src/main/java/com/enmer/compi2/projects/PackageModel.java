/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.enmer.compi2.projects;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class PackageModel {
    private String name;
    private List<FileModel> files = new ArrayList<>();

    public PackageModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FileModel> getFiles() {
        return files;
    }

    public void setFiles(List<FileModel> files) {
        this.files = files;
    }

     
    
    
}
