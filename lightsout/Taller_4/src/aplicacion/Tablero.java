package aplicacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Tablero extends JPanel {
    private int gridSize; // Tamaño de la cuadrícula
    private boolean[][] lights;

    public Tablero(int gridSize) {
        this.gridSize = gridSize;
        lights = new boolean[gridSize][gridSize];
        
        // Inicializa la matriz de luces al azar
        initializeLights();

        // Agrega un MouseAdapter para cambiar el estado de las luces al hacer clic en ellas
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int cellSize = getWidth() / gridSize;
                int row = e.getY() / cellSize;
                int col = e.getX() / cellSize;
                if (row >= 0 && row < gridSize && col >= 0 && col < gridSize) {
                    toggleLights(row, col);
                    repaint();
                    checkWin();
                }
            }
        });
    }

    private void initializeLights() {
        // Inicializa las luces al azar
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                lights[i][j] = Math.random() < 0.5;
            }
        }
    }

    private void toggleLights(int row, int col) {
        // Cambia el estado de la luz y las luces adyacentes
        lights[row][col] = !lights[row][col];

        int[][] directions = {{0, 0}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newRow < gridSize && newCol >= 0 && newCol < gridSize) {
                lights[newRow][newCol] = !lights[newRow][newCol];
            }
        }
    }

    private void checkWin() {
        // Comprueba si todas las luces están apagadas (el jugador ha ganado)
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (lights[i][j]) {
                    return;
                }
            }
        }
        JOptionPane.showMessageDialog(this, "¡Has ganado!");
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int cellSize = getWidth() / gridSize;

        // Dibuja las luces en la cuadrícula
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (lights[i][j]) {
                    g.setColor(Color.WHITE);
                } else {
                    g.setColor(Color.BLACK);
                }
                g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Lights Out Game");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);

            Tablero game = new Tablero(5);
            frame.add(game);

            frame.setVisible(true);
        });
    }
}

