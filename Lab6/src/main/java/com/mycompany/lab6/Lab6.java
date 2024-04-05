/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.lab6;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author rebec
 */
public class Lab6 {

    private static int gridSize = 8;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("My JFrame");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel panelSouth = new JPanel();
        JPanel panelNorth = new JPanel();
        JPanel panelCenter = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int size = Math.min(getWidth(), getHeight());
                int squareSize = size / (gridSize - 1);
                int xOffset = (getWidth() - size) / 2;
                int yOffset = (getHeight() - size) / 2;
                for (int i = 0; i < gridSize - 1; i++) {
                    for (int j = 0; j < gridSize - 1; j++) {
                        g.drawRect(i * squareSize + xOffset, j * squareSize + yOffset, squareSize, squareSize);
                    }
                }
            }
        };

        JTextField gridSizeField = new JTextField(Integer.toString(gridSize), 3);
        JButton updateButton = new JButton("Update Grid Size");

        panelNorth.add(new JLabel("Grid Size:"));
        panelNorth.add(gridSizeField);
        panelNorth.add(updateButton);

        panelSouth.add(new JButton("Save"));
        panelSouth.add(new JButton("Exit"));
        panelSouth.add(new JButton("Load"));

        frame.add(panelSouth, BorderLayout.SOUTH);
        frame.add(panelNorth, BorderLayout.NORTH);
        frame.add(panelCenter, BorderLayout.CENTER);

        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                panelCenter.repaint();
            }
        });
        
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    gridSize = Integer.parseInt(gridSizeField.getText());
                    panelCenter.repaint(); 
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid grid size. Please enter a positive integer.");
                }
            }
        });
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
        
    }
}
       