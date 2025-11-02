/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.enmer.compi2.projects;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.nio.file.*;
/**
 *
 * @author Admin
 */
public class ProjectXML {
     public static ProjectModel createNew(String name, Path root) throws Exception {
        Files.createDirectories(root);

        ProjectModel project = new ProjectModel(name, root);
        PackageModel pkg = new PackageModel("default");
        project.getPackages().add(pkg);

        save(project, root.resolve("project.xml"));
        return project;
    }

    public static void save(ProjectModel project, Path xmlPath) throws Exception {
        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        DocumentBuilder b = f.newDocumentBuilder();
        Document doc = b.newDocument();

        Element rootEl = doc.createElement("project");
        rootEl.setAttribute("name", project.getName());
        rootEl.setAttribute("root", project.getRoot().toString());
        doc.appendChild(rootEl);

        for (PackageModel pkg : project.getPackages()) {
            Element pkgEl = doc.createElement("package");
            pkgEl.setAttribute("name", pkg.getName());

            for (FileModel fm : pkg.getFiles()) {
                Element fileEl = doc.createElement("file");
                fileEl.setAttribute("name", fm.getName());
                fileEl.setAttribute("path", fm.getPath());
                pkgEl.appendChild(fileEl);
            }
            rootEl.appendChild(pkgEl);
        }

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        t.transform(new DOMSource(doc), new StreamResult(xmlPath.toFile()));
    }

    public static ProjectModel load(Path xmlPath) throws Exception {
        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        DocumentBuilder b = f.newDocumentBuilder();
        Document doc = b.parse(xmlPath.toFile());

        Element rootEl = doc.getDocumentElement();
        String name = rootEl.getAttribute("name");
        Path root = Paths.get(rootEl.getAttribute("root"));

        ProjectModel project = new ProjectModel(name, root);

        NodeList pkgNodes = rootEl.getElementsByTagName("package");
        for (int i = 0; i < pkgNodes.getLength(); i++) {
            Element pkgEl = (Element) pkgNodes.item(i);
            PackageModel pkg = new PackageModel(pkgEl.getAttribute("name"));

            NodeList fileNodes = pkgEl.getElementsByTagName("file");
            for (int j = 0; j < fileNodes.getLength(); j++) {
                Element fileEl = (Element) fileNodes.item(j);
                FileModel fm = new FileModel(
                        fileEl.getAttribute("name"),
                        fileEl.getAttribute("path")
                );
                pkg.getFiles().add(fm);
            }

            project.getPackages().add(pkg);
        }

        return project;
    }
}
