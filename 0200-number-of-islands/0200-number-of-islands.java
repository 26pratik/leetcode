class Solution {
    
    int m, n;
    int[][] dirs;
    public int numIslands(char[][] grid) {
        
        m = grid.length;
        n = grid[0].length;
        dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        int count = 0;
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
                    
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, int i, int j) {
        
        for(int[] dir: dirs) {
            int row = i + dir[0];
            int col = j + dir[1];
            
            if(row>=0 && col>=0 && row<m && col<n && grid[row][col] == '1') {
                grid[row][col] = '0';
                dfs(grid, row, col);
            }
        }
    }
}