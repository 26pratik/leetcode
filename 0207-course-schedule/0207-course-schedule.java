
//TC: 
//SC:
//Topological sort in a directed acyclic graph 
class Solution {
    
    HashMap<Integer, List<Integer>> map;
    boolean[] visited;
    boolean[] path;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        map = new HashMap<>();
        visited = new boolean[numCourses];
        path = new boolean[numCourses];
        
        for(int i=0; i<prerequisites.length; i++) {
            if(!map.containsKey(prerequisites[i][0]))
                map.put(prerequisites[i][0], new ArrayList<>());
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
        for(int i=0; i<numCourses; i++) {
            if(!visited[i] && hasCycle(i))
                return false;
        }
        
        return true;
    }
    
    private boolean hasCycle(int course) {
        
        //base
        if(path[course]) return true;
        if(visited[course]) return false;
        
        //logic
        path[course] = true;
        List<Integer> list = map.get(course);
        if(list != null) {
            for(int i=0; i<list.size(); i++) {
                if(!visited[list.get(i)] && hasCycle(list.get(i)))
                    return true;
            }
        }
        
        path[course] = false;
        visited[course] = true;
        
        return false;
    }
}