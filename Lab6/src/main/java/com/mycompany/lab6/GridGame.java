package com.mycompany.lab6;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Random;
import javax.swing.*;

public class GridGame extends JFrame {
    private static int gridSize = 10;
    private static boolean[][] horizontalSticks;
    private static boolean[][] verticalSticks;
    
    public GridGame(){
        JFrame frame = new JFrame();
        frame.setTitle("GridGame");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel panelSouth = new JPanel();
        JPanel panelNorth = new JPanel();
        JPanel panelCenter = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(Color.BLACK);
                
                int size = Math.min(getWidth(), getHeight());
                int squareSize = size / (gridSize - 1);
                int xOffset = (getWidth() - size) / 2;
                int yOffset = (getHeight() - size) / 2;
                for (int i = 0; i < gridSize - 1; i++) {
                    for (int j = 0; j < gridSize - 1; j++) {
                        g.drawRect(i * squareSize + xOffset, j * squareSize + yOffset, squareSize, squareSize);
//                        if (grid[i][j]) {
//                            g2d.drawLine(i * squareSize + xOffset, j * squareSize + yOffset,
//                                       (i + 1) * squareSize + xOffset, (j + 1) * squareSize + yOffset);
//                        }
                    }
                }
                
                g2d.setStroke(new BasicStroke(4));
                //Draw horizontal sticks
                  for (int i = 0; i < gridSize; i++) {
                    for (int j = 0; j < gridSize - 1; j++) {
                        if (horizontalSticks[i][j]) {
                            int x1 = j * squareSize + xOffset;
                            int y1 = i * squareSize + yOffset;
                            int x2 = (j + 1) * squareSize + xOffset;
                            g2d.drawLine(x1, y1, x2, y1);
                        }
                    }
                }

                // Draw vertical sticks
                for (int i = 0; i < gridSize - 1; i++) {
                    for (int j = 0; j < gridSize; j++) {
                        if (verticalSticks[i][j]) {
                            int x1 = j * squareSize + xOffset;
                            int y1 = i * squareSize + yOffset;
                            int y2 = (i + 1) * squareSize + yOffset;
                            g2d.drawLine(x1, y1, x1, y2);
                        }
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
        generateSticks();
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
    }
    
    private static void generateSticks() {
        horizontalSticks = new boolean[gridSize][gridSize - 1];
        verticalSticks = new boolean[gridSize - 1][gridSize];
        Random random = new Random();

        // Randomly place horizontal sticks
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize - 1; j++) {
                horizontalSticks[i][j] = random.nextBoolean();
            }
        }

        // Randomly place vertical sticks
        for (int i = 0; i < gridSize - 1; i++) {
            for (int j = 0; j < gridSize; j++) {
                verticalSticks[i][j] = random.nextBoolean();
            }
        }
    }
}
