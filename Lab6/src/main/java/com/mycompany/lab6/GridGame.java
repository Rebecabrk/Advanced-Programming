package com.mycompany.lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridGame extends JFrame {
    private static final int SIZE = 5; // Grid size
    private JButton[][] buttons = new JButton[SIZE][SIZE];

    public GridGame() {
        setTitle("Grid Game");
        setLayout(new GridLayout(SIZE, SIZE));
        initializeBoard();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setPreferredSize(new Dimension(100, 100));
                buttons[i][j].addActionListener(new ButtonListener());
                add(buttons[i][j]);
            }
        }
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            button.setBackground(button.getBackground() == Color.RED ? Color.BLUE : Color.RED);
        }
    }
}
