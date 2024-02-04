class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    cnt++;
                    dfs(grid, i, j, visited);
                }
            }
        }

        return cnt;
    }

    static void dfs(char[][] grid, int i, int j, boolean[][] visited) {
        int n = grid.length;
        int m = grid[0].length;
        visited[i][j] = true;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : directions) {
            int nrow = i + dir[0];
            int ncol = j + dir[1];

            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == '1' && !visited[nrow][ncol]) {
                dfs(grid, nrow, ncol, visited);
            }
        }
    }
}
