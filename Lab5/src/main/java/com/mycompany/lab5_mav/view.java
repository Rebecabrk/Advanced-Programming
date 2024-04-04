/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab5_mav;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author rebec
 */
public class view {
    public static void view(File file){
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.open(file);
            } catch (IOException e) {
                System.out.println("An error occurred while trying to open the file: " + e.getMessage());
            }
        } else {
            System.out.println("Desktop is not supported on this platform.");
        }
    }
}
