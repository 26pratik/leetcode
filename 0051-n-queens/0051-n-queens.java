class Solution {
    
    List<List<String>> result;
    boolean[][] board;
    
    public List<List<String>> solveNQueens(int n) {
        
        this.result = new ArrayList<>();
        this.board = new boolean[n][n];    
        
        dfs(0, n);
        
        return result;
    }
    
    private void dfs(int row, int n) {
        
        if(row == n) {
            List<String> temp = new ArrayList<>();
            for(int i=0; i<n; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<n; j++) {
                    if(board[i][j])
                        sb.append("Q");
                    else
                        sb.append(".");
                }
                temp.add(sb.toString());
            }
            result.add(temp);
            return;
        }
        
        for(int j=0; j<n; j++) {
            if(isSafe(row, j, n)) {
                board[row][j] = true;
                dfs(row+1, n);
                board[row][j] = false;
            }
        }
    }
    
    private boolean isSafe(int row, int col, int n) {
        
        int i = row-1;
        int j = col;
        
        while(i>=0) {
            if(board[i][j]) 
                return false;
            i--;
        }
        
        i = row-1;
        j = col-1;
        while(i>=0 && j>=0) {
            if(board[i][j]) 
                return false;
            i--;
            j--;
        }
        
        i = row-1;
        j = col+1;
        
        while(i>=0 && j<n) {
            if(board[i][j]) 
                return false;
            i--;
            j++;
        }
        
        return true;
    }
}