class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] indegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int count = 0;
        
        for(int[] pr: prerequisites) {
            
            indegrees[pr[0]]++;
            
            if(!map.containsKey(pr[1])) 
                map.put(pr[1], new ArrayList<>());
            map.get(pr[1]).add(pr[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<numCourses; i++) {
            if(indegrees[i] == 0) {
                q.add(i);
                count++;
            }
        }
        
        if(count == numCourses) return true;
        
        while(!q.isEmpty()) {
            
            Integer course = q.poll();
            List<Integer> list = map.get(course);
            
            if(list != null) {
                for(Integer i: list) {

                    indegrees[i]--;

                    if(indegrees[i] == 0) {
                        q.add(i);
                        count++;

                        if(count == numCourses) return true;
                    }
                }                
            }
        }
        
        return false;
    }
}