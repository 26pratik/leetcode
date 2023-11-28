class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        result.add(new ArrayList<>(Arrays.asList(1)));
        
        for(int i=1; i<numRows; i++){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            List<Integer> temp = result.get(i-1); 
            for(int j=1; j<i; j++) 
                list.add(temp.get(j-1) + temp.get(j));
            list.add(1);
            result.add(list);
        }
        
        return result;
    }
}