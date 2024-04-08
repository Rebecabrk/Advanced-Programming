/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab6;

import java.awt.Desktop;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author rebec
 */
public class ControlPanel extends JPanel {

    final MainFrame frame;
    JButton exitBtn;
    JButton exportBtn;
    JButton saveBtn;

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        exitBtn = new JButton("Exit");
        exportBtn = new JButton("Export");
        saveBtn = new JButton("Save");

        add(exitBtn);
        add(exportBtn);
        add(saveBtn);

        exitBtn.addActionListener(this::exitGame);
        exportBtn.addActionListener(this::exportGame);
    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }

    private void exportGame(ActionEvent e) {
        frame.canvas.export();
        openImage();
    }
    
    private void openImage() {
    File file = new File("gameBoard.png");
    if (!Desktop.isDesktopSupported()) {
        System.out.println("Desktop is not supported");
        return;
    }
    Desktop desktop = Desktop.getDesktop();
    if (file.exists()) {
        try {
            desktop.open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    } else {
        System.out.println("The file gameBoard.png does not exist");
    }
}
}
