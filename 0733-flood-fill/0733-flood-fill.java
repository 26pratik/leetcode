class Solution {
    
    int m, n;
    int oldColor;
    int color;
    int[][] dirs;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        if(image[sr][sc] == color) return image;
        
        this.dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        this.m = image.length;
        this.n = image[0].length;
        this.color = color;
        this.oldColor = image[sr][sc];        
        
        dfs(image, sr, sc);
 
        return image;
    }
    
    private void dfs(int[][] image, int row, int col) {
        
        image[row][col] = color;
        
        for(int[] dir: dirs) {
            int r = row + dir[0];
            int c = col + dir[1];
            
            if(r>=0 && c>=0 && r<m && c<n && image[r][c] == oldColor)
                dfs(image, r, c);
        }
    }
}