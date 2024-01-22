class Solution {
    public List<Integer> partitionLabels(String s) {
        
        int[] arr = new int[26];
        List<Integer> result = new ArrayList<>();
        
        int n = s.length();
        for(int i=0; i<n; i++) {
            arr[s.charAt(i)-'a'] = i;
        }
        
        int min = 0, max = 0;
        
        for(int i=0; i<n; i++) {
            int freq = arr[s.charAt(i)-'a'];
            if(freq > max)
                max = freq;
            
            if(max == i) {
                result.add(max-min+1);
                min = i + 1;
            }
        }
        
        return result;
    }
}