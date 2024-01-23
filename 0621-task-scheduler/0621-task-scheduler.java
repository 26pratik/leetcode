class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int maxFreq = 0;
        int maxCount = 0;
        int[] arr = new int[26];
        for(char c: tasks) {
            arr[c-'A']++;
            int freq = arr[c-'A'];
            
            if(freq > maxFreq) {
                maxFreq = freq;
                maxCount = 1;
            }
            else if(freq == maxFreq) {
                maxCount++;
            }
        }
        
        int partitions = maxFreq - 1;
        int availableSlots = (n - (maxCount-1)) * partitions;
        int pendingSlots = tasks.length - (maxFreq * maxCount);
        int idleSlots = Math.max(0, availableSlots - pendingSlots);
        
        return tasks.length + idleSlots;
    }
}