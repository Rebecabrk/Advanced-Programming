/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab6;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author rebec
 */
public class DrawingPanel extends JPanel {

    private final MainFrame frame;
    static int rows, cols;
    int canvasWidth = 400, canvasHeight = 400;
    int boardWidth, boardHeight;
    int cellWidth, cellHeight;
    int padX, padY;
    int stoneSize = 20;
    private boolean isPlayer1Turn;
    private static boolean[][] horizontalSticks;
    private static boolean[][] verticalSticks;
    int[][] board;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        init(frame.configPanel.getRows(), frame.configPanel.getCols());
    }

    final void init(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.padX = stoneSize + 10;
        this.padY = stoneSize + 10;
        this.cellWidth = (canvasWidth - 2 * padX) / (cols - 1);
        this.cellHeight = (canvasHeight - 2 * padY) / (rows - 1);
        this.boardWidth = (cols - 1) * cellWidth;
        this.boardHeight = (rows - 1) * cellHeight;
        this.isPlayer1Turn = true;
        this.board = new int[rows][cols];
        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int X = (e.getX() - padX) / cellWidth;
                int Y = (e.getY() - padY) / cellHeight;

                if (isValidMove(X, Y)) {
                    drawStone(X, Y);
                    board[X][Y] = isPlayer1Turn ? 1 : 2; // update the board state
                    isPlayer1Turn = !isPlayer1Turn;
                }
            }
        });
    }
    
    private boolean isValidMove(int X, int Y) {
    // Check if the cell is empty
    if (board[X][Y] != 0) {
        return false;
    }
    boolean isFirstMove = true;
    for (int[] row : board) {
        for (int cell : row) {
            if (cell != 0) {
                isFirstMove = false;
                break;
            }
        }
        if (!isFirstMove) {
            break;
        }
    }
    if (isFirstMove) {
        return true;
    }

    // Check if the cell is adjacent to a cell of the other color
    for (int dx = -1; dx <= 1; dx++) {
        for (int dy = -1; dy <= 1; dy++) {
            int newX = X + dx;
            int newY = Y + dy;
            if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && board[newX][newY] == (isPlayer1Turn ? 2 : 1)) {
                return true;
            }
        }
    }

    return false;
}

    private void drawStone(int X, int Y) {
        Graphics2D g = (Graphics2D) getGraphics();
        if (isPlayer1Turn) {
            g.setColor(Color.RED);
        } else {
            g.setColor(Color.BLUE);
        }
        int x = padX + X * cellWidth;
        int y = padY + Y * cellHeight;
        g.fillOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
    }

    private void paintGrid(Graphics2D g) {
        paintSticks();
        g.setColor(Color.DARK_GRAY);
        g.setStroke(new BasicStroke(1));

        // Draw horizontal lines
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols - 1; col++) {
                if (horizontalSticks[row][col]) {
                    g.setColor(Color.BLACK);
                    g.setStroke(new BasicStroke(4));
                }
                int x1 = padX + col * cellWidth;
                int y1 = padY + row * cellHeight;
                int x2 = x1 + cellWidth;
                int y2 = y1;
                g.drawLine(x1, y1, x2, y2);
                g.setColor(Color.DARK_GRAY);
                g.setStroke(new BasicStroke(1));
            }
        }

        // Draw vertical lines
        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows - 1; row++) {
                if (verticalSticks[row][col]) {
                    g.setColor(Color.BLACK);
                    g.setStroke(new BasicStroke(4));
                }
                int x1 = padX + col * cellWidth;
                int y1 = padY + row * cellHeight;
                int x2 = x1;
                int y2 = y1 + cellHeight;
                g.drawLine(x1, y1, x2, y2);
                g.setColor(Color.DARK_GRAY);
                g.setStroke(new BasicStroke(1));
            }
        }

        //intersections
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = padX + col * cellWidth;
                int y = padY + row * cellHeight;
                g.setColor(Color.LIGHT_GRAY);
                g.drawOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
            }
        }
    }

    private static void paintSticks() {
        horizontalSticks = new boolean[rows][cols - 1];
        verticalSticks = new boolean[rows - 1][cols];
        Random random = new Random();

        // Randomly place horizontal sticks
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols - 1; j++) {
                horizontalSticks[i][j] = random.nextBoolean();
            }
        }

        // Randomly place vertical sticks
        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < cols; j++) {
                verticalSticks[i][j] = random.nextBoolean();
            }
        }
    }

    @Override
    public void update(Graphics g) {
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, canvasWidth, canvasHeight);
        paintGrid(g);
    }
    
    public void export(){
        BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = image.createGraphics();
        paint(graphics2D);
        graphics2D.dispose();

        try {
            ImageIO.write(image, "png", new File("gameBoard.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
