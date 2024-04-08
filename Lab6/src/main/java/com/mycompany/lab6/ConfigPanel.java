/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab6;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author rebec
 */
public class ConfigPanel extends JPanel {

    private final MainFrame frame;
    JLabel label;
    JSpinner rowSpinner;
    JSpinner colSpinner;
    JButton update;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        label = new JLabel("Grid size:");
        rowSpinner = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        colSpinner = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        update = new JButton("Update Grid Size");
        update.addActionListener(this::updateGrid);
        
        add(label);
        add(rowSpinner);
        add(colSpinner);
        add(update);
    }
    public int getRows(){
        return (Integer) rowSpinner.getValue();
    }
    public int getCols(){
        return (Integer) colSpinner.getValue();
    }
    public void updateGrid(ActionEvent a){
        frame.canvas.init((Integer) rowSpinner.getValue(), (Integer) colSpinner.getValue());
        frame.canvas.repaint();
    }
}
