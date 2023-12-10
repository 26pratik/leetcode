class Solution {
    int m, n;
    public boolean isValidSudoku(char[][] board) {
        
        this.m = board.length;
        this.n = board[0].length;
        
        if(checkRow(board) && checkCol(board) && checkCells(board)) return true;
        
        return false;
    }
    
    private boolean checkRow(char[][] board) {
        
        for(int i=0; i<m; i++) {      
            HashSet<Character> set = new HashSet<>();    
            for(int j=0; j<n; j++)
                if(!check(board[i][j], set)) return false;
        }      
        return true;
    }
    
    private boolean checkCol(char[][] board) {
        
        for(int i=0; i<m; i++) {
            HashSet<Character> set = new HashSet<>(); 
            for(int j=0; j<n; j++)
                if(!check(board[j][i], set)) return false;
        }  
        return true;        
    }
    
    private boolean checkCells(char[][] board) {
        
        for(int a=0; a<9; a+=3)
            for(int b=0; b<9; b+=3) { 
                HashSet<Character> set = new HashSet<>();
                for(int i=a; i<a+3; i++)
                    for(int j=b; j<b+3; j++) 
                        if(!check(board[i][j], set)) return false;
            }  
        return true;
    }
    
    private boolean check(char c, HashSet<Character> set) {
        if(c != '.')
            if(set.contains(c)) return false;
            else set.add(c);
        return true;
    }
}