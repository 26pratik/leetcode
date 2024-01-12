class Solution {
    
    final static int k = 10000;
    
    public int arrayPairSum(int[] nums) {
        
        int[] arr = new int[2*k+1];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int result = 0;
        
        for(int n: nums) {
            max = Math.max(max, n);
            min = Math.min(min, n);
            arr[k+n]++;
        }

        boolean flag = false;
        for(int i=min; i<=max; i++) {
            if(arr[k+i] > 0) {
                if(flag) arr[k+i]--;
                int cnt = arr[k+i];
                result += cnt/2*(i);
                if(cnt%2 == 0) {
                    flag = false;
                }
                else {
                    flag = true;
                    result += (i);
                }                
            }
        }
        
        return result;
    }
}