/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javafx;

/**
 *
 * @author rebec
 */
public class HelloWorld extends Application {

    @Override
    public void start(Stage primaryStage) { //The main entry point
        Button helloBtn = new Button();
        helloBtn.setText("Hello World!");

        FlowPane root = new FlowPane();
        root.getChildren().add(helloBtn);
        Scene scene = new Scene(root, 300, 250);
        //The UI is defined by a stage and a scene. 
        //Stage class is the top-level JavaFX container. 
        //The Scene class is the container for all content. 
        primaryStage.setTitle("Hello World Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); //not required for JavaFX applications...
    }
}
