class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        
        Collections.sort(tasks);
        Collections.sort(processorTime, Collections.reverseOrder());
        
        int ans = 0; 
        int index = 0;
        for(Integer i: processorTime) {
            int currentMax = 0;       
            for(int j=0; j<4; j++) {
                currentMax = Math.max(currentMax, i+tasks.get(index));
                index++;
            }
            ans = Math.max(ans, currentMax);
        }
        
        return ans;
    }
}