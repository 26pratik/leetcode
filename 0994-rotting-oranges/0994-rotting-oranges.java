class Solution {
    public int orangesRotting(int[][] grid) {
        
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        int time = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 2)
                    q.add(new int[]{i, j});
                else if(grid[i][j] == 1)
                    fresh++;
            }
        }
        
        if(fresh == 0) return time;
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            for(int i=0; i<size; i++) {
                int[] current = q.poll();
                for(int[] dir: dirs) {
                    
                    int row = current[0] + dir[0];
                    int col = current[1] + dir[1];
                    
                    if(row>=0 && col>=0 && row<m && col<n && grid[row][col] == 1) {
                        grid[row][col] = 2;
                        q.add(new int[]{row, col});
                        fresh--;
                    }
                }
            }
            time++;
        }
        
        if(fresh == 0) return time-1;
        
        return -1;
    }
}