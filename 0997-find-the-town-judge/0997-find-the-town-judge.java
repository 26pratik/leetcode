class Solution {
    public int findJudge(int n, int[][] trust) {
        
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i=1; i<=n; i++) {
            set.add(i);
            map.put(i, new ArrayList<>());
        }
        
        for(int i=0; i<trust.length; i++) {
            int judge = trust[i][1];
            int person = trust[i][0];

            map.get(judge).add(person);
            
            if(set.contains(person))
                set.remove(person);
        }
        
        for(Integer i: set)
            if(map.containsKey(i) && map.get(i).size() == n-1)
                return i;
        
        return -1;
    }
}