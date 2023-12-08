class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        if(image[sr][sc] == color) return image;
        
        int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        Queue<int[]> q = new LinkedList<>();
        int m = image.length;
        int n = image[0].length;
        
        int oldColor = image[sr][sc];        
        
        q.add(new int[]{sr, sc});
        image[sr][sc] = color;
        
        while(!q.isEmpty()) {
            
            int[] curr = q.poll();
            
            for(int[] dir: dirs) {
                int row = curr[0] + dir[0];
                int col = curr[1] + dir[1];
                
                if(row>=0 && col>=0 && row<m && col<n && image[row][col] == oldColor) {
                    q.add(new int[]{row, col});
                    image[row][col] = color;
                }
            }
        }
        
        return image;
    }
}