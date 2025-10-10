import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MazeVisualizer extends JPanel {

    static final int CELL_SIZE = 50;
    static final int ROWS = 3;
    static final int COLS = 3;
    static ArrayList<int[][]> pathGrids = new ArrayList<>();

    public static void main(String[] args) {
        boolean[][] maze = {
                {true, true, true},
                {true, true, true},
                {true, true, true},
        };

        int[][] path = new int[ROWS][COLS];
        allPathStep("", maze, 0, 0, path, 1);

        JFrame frame = new JFrame("Maze Path Visualizer 🧠");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(COLS * CELL_SIZE + 15, ROWS * CELL_SIZE + 38);
        frame.setContentPane(new MazeVisualizer());
        frame.setVisible(true);
    }

    static void allPathStep(String p, boolean[][] maze, int r, int c, int[][] path, int step) {
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            path[r][c] = step;
            int[][] pathCopy = new int[ROWS][COLS];
            for (int i = 0; i < ROWS; i++) {
                System.arraycopy(path[i], 0, pathCopy[i], 0, COLS);
            }
            pathGrids.add(pathCopy);
            path[r][c] = 0;
            return;
        }

        if (!maze[r][c]) return;

        maze[r][c] = false;
        path[r][c] = step;

        if (c < maze[0].length - 1)
            allPathStep(p + 'R', maze, r, c + 1, path, step + 1);
        if (r < maze.length - 1)
            allPathStep(p + 'D', maze, r + 1, c, path, step + 1);
        if (c > 0)
            allPathStep(p + 'L', maze, r, c - 1, path, step + 1);
        if (r > 0)
            allPathStep(p + 'U', maze, r - 1, c, path, step + 1);

        maze[r][c] = true;
        path[r][c] = 0;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int p = 0; p < pathGrids.size(); p++) {
            int[][] grid = pathGrids.get(p);
            drawGrid(g, grid);
            try {
                Thread.sleep(700);  // delay between paths
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void drawGrid(Graphics g, int[][] grid) {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                int step = grid[r][c];

                if (step > 0) {
                    g.setColor(new Color(173, 216, 230)); // Light blue for path
                } else {
                    g.setColor(Color.LIGHT_GRAY); // Unvisited
                }

                g.fillRect(c * CELL_SIZE, r * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                g.setColor(Color.BLACK);
                g.drawRect(c * CELL_SIZE, r * CELL_SIZE, CELL_SIZE, CELL_SIZE);

                if (step > 0) {
                    g.setColor(Color.BLACK);
                    g.drawString(String.valueOf(step), c * CELL_SIZE + 20, r * CELL_SIZE + 30);
                }
            }
        }
    }
}
