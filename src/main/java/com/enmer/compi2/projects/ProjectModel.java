    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.enmer.compi2.projects;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ProjectModel {
    private String name;
    private Path root;
    private List<PackageModel> packages = new ArrayList<>();

    public ProjectModel(String name, Path root) {
        this.name = name;
        this.root = root;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Path getRoot() {
        return root;
    }

    public void setRoot(Path root) {
        this.root = root;
    }

    public List<PackageModel> getPackages() {
        return packages;
    }

    public void setPackages(List<PackageModel> packages) {
        this.packages = packages;
    }   
    
}
