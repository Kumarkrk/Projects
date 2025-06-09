import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class State {
     int r, c, dist;
    boolean usedTeleport;
    State(int r, int c, int dist, boolean used) {
        this.r = r; this.c = c; this.dist = dist; this.usedTeleport = used;
    }
}

public class KnightsAndPortals {
    public static int shortestPath(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        List<int[]> empty = new ArrayList<>();
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (grid[i][j] == 0) empty.add(new int[]{i, j});

        Queue<State> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(new State(0, 0, 0, false));

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!q.isEmpty()) {
            State s = q.poll();
            String key = s.r + "," + s.c + "," + s.usedTeleport;
            if (!visited.add(key)) continue;

            if (s.r == rows - 1 && s.c == cols - 1) return s.dist;

            for (int[] d : dirs) {
                int nr = s.r + d[0], nc = s.c + d[1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 0)
                    q.offer(new State(nr, nc, s.dist + 1, s.usedTeleport));
            }

            if (!s.usedTeleport) {
                for (int[] cell : empty)
                    if (cell[0] != s.r || cell[1] != s.c)
                        q.offer(new State(cell[0], cell[1], s.dist + 1, true));
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {0, 1, 0},
            {0, 1, 0},
            {0, 0, 0}
        };
        System.out.println("Shortest path: " + shortestPath(grid));
    }
    
}
