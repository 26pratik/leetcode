class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        
        List<Integer> low = new ArrayList<>();
        List<Integer> high = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        int[] result = new int[nums.length];
        
        for(int i: nums) {
            if(i < pivot)
                low.add(i);
            else if(i == pivot)
                equal.add(i);
            else
                high.add(i);
        }
        
        int i=0;
        while(i != nums.length) {
            for(Integer x: low) 
                result[i++] = x;
            for(Integer x: equal) 
                result[i++] = x;
            for(Integer x: high) 
                result[i++] = x;
        }
        
        return result;
    }
}