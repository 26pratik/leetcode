class Solution {
    int[][] dirs = new int[][]{{0,1}, {-1,0}, {0,-1}, {1,0}};
    public boolean isRobotBounded(String instructions) {
        int d = 0;
        int x = 0;
        int y = 0;
        for(int i=0; i<instructions.length(); i++){
            char c = instructions.charAt(i);
            if(c == 'G'){
                x = x + dirs[d][0];
                y = y + dirs[d][1];
            }else if(c == 'L'){
                d++;
            }else{
                d--;
            }
            if(d > 3){
                d = 0;
            }
            if(d < 0){
                d = 3;
            }
        }
        if(x == 0 && y == 0){
            return true;
        }
        
        if(d == 0){
            return false;
        }
        return true;
    }
}