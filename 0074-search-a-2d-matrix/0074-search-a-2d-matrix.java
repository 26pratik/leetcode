class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        
        int low = 0; 
        int high = (rowLen * colLen) - 1;
        
        while(low <= high) {
            
            int mid = low + (high-low)/2;
            int row = mid / colLen;
            int col = mid % colLen;
            
            if(matrix[row][col] == target)
                return true;
            else if (target < matrix[row][col])
                high = mid - 1;
            else
                low = mid + 1;
        }
        
        return false;
    }
}