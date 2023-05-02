import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

public class Bacteria {
    private int row;
    private int column;
    private char[][] layout;
    private boolean[][] visited;

    // puts it into a 2 dimensional array
    public Bacteria() {
        Scanner sc;
        try {
            sc = new Scanner(new File("DATA_100x200.txt")); // or use other file name
            row = sc.nextInt();
            column = sc.nextInt();
            layout = new char[row][column];
            visited = new boolean[column][row];
            for (int i = 0; i < row; i++) {
                layout[i] = sc.next().toCharArray();
            }
            sc.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void find() {
        for (int y = 0; y < row; y++) {
            for (int x = 0; x < column; x++) {
                if (!visited[x][y]) {
                    visited[x][y] = true;
                    if (layout[y][x] != '_') {
                        solve(x, y);
                    }
                }
            }
        }
    }

    // scans through the array and checks for colonies

    public void solve(int startX, int startY) {
        Queue<int[]> toCheck = new LinkedList<>();
        toCheck.add(new int[] { startX, startY });
        int size = 0;

        while (!toCheck.isEmpty()) {
            int[] cur = toCheck.poll();
            int x = cur[0], y = cur[1];
            size++;

            if (0 <= x + 1 && x + 1 < column && !visited[x + 1][y] && layout[y][x + 1] != '_') {
                toCheck.add(new int[] { x + 1, y });
                visited[x + 1][y] = true;
            }

            if (0 <= x - 1 && x - 1 < column && !visited[x - 1][y] && layout[y][x - 1] != '_') {
                toCheck.add(new int[] { x - 1, y });
                visited[x - 1][y] = true;
            }

            if (0 <= y + 1 && y + 1 < row && !visited[x][y + 1] && layout[y + 1][x] != '_') {
                toCheck.add(new int[] { x, y + 1 });
                visited[x][y + 1] = true;
            }

            if (0 <= y - 1 && y - 1 < row && !visited[x][y - 1] && layout[y - 1][x] != '_') {
                toCheck.add(new int[] { x, y - 1 });
                visited[x][y - 1] = true;
            }
        }

        System.out.println("(" + startY + ", " + startX + ") " + size);
    }

    public static void main(String[] args) {
        Bacteria bacteria = new Bacteria();
        bacteria.find();
    }
}
