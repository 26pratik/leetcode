class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        
        int row = 0, col = 0, m = mat.length, n = mat[0].length;
        int[] result = new int[m*n];
        boolean dirUp = true;
        
        result[0] = mat[row][col];
        for(int i=0; i<m*n; i++) {
            if(dirUp) {
                result[i] = mat[row][col];
                
                if(row == 0 || col == n-1) {
                    dirUp = false;
                    if(row == 0)
                        if(col == n-1)
                            row++;
                        else
                            col++;
                    else
                        row++;
                }
                else {
                    row--;
                    col++;
                }
            }
            else {
                result[i] = mat[row][col];

                if(col == 0 || row == m-1) {
                    dirUp = true;
                    if(col == 0)
                        if(row == m-1)
                            col++;
                        else
                            row++;
                    else
                       col++; 
                }
                else {
                    row++;
                    col--;
                }
            }
        }
        
        return result;
    }
}