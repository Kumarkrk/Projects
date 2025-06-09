public class MatrixIslandsWithDiagonals {
    static int ROWS, COLS;

    // 8 directions: horizontal, vertical, and diagonal
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static int countIslands(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        boolean[][] visited = new boolean[ROWS][COLS];
        int islandCount = 0;

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    public static void dfs(int[][] grid, boolean[][] visited, int x, int y) {
        visited[x][y] = true;

        for (int dir = 0; dir < 8; dir++) {
            int newX = x + dx[dir];
            int newY = y + dy[dir];

            if (isValid(grid, visited, newX, newY)) {
                dfs(grid, visited, newX, newY);
            }
        }
    }

    public static boolean isValid(int[][] grid, boolean[][] visited, int x, int y) {
        return x >= 0 && x < ROWS &&
               y >= 0 && y < COLS &&
               grid[x][y] == 1 &&
               !visited[x][y];
    }

    // Example usage
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 1, 0, 0},
            {0, 1, 1, 0},
            {0, 0, 1, 0},
            {1, 0, 0, 0}
        };

        int result = countIslands(matrix);
        System.out.println("Number of islands (with diagonals): " + result);
    }
}
