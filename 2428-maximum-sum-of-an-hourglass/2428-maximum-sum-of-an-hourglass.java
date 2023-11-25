class Solution {
    
    int[][] dirs;
    
    public int maxSum(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        this.dirs = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, 0}, {1, -1}, {1, 0}, {1, 1}};
        int max = 0;
        
        for(int i=1; i<m-1; i++) {
            for(int j=1; j<n-1; j++) {
                int sum = calculateSum(grid, i, j);
                max = Math.max(max, sum);
            }
        }
        
        return max;
    }
    
    private int calculateSum(int[][] grid, int i, int j) {
        
        int sum = 0;
        
        for(int[] dir: dirs) {
            int row = i+dir[0];
            int col = j+dir[1];
            
            sum += grid[row][col];
        }
        
        return sum;
    } 
}