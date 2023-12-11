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
                    bfs(grid, i, j);
                    count++;
                }
                    
            }
        }
        return count;
    }
    
    private void bfs(char[][] grid, int i, int j) {
        
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{i, j});
        grid[i][j] = '0';
        
        while(!q.isEmpty()) {
            
            int[] curr = q.poll();
            
            for(int[] dir: dirs) {
                int row = curr[0] + dir[0];
                int col = curr[1] + dir[1];
                
                if(row>=0 && col>=0 && row<m && col<n && grid[row][col] == '1') {
                    grid[row][col] = '0';
                    q.add(new int[]{row, col});
                }
            }
        }
    }
}