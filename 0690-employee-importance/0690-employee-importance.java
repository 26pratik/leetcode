/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    
    HashMap<Integer, Employee> map;
    
    public int getImportance(List<Employee> employees, int id) {
        
        this.map = new HashMap<>();
        
        for(Employee e: employees) 
            map.put(e.id, e);
        
        return dfs(id);
    }
    
    private int dfs(int id) {
        
        Employee e = map.get(id);
        int result = e.importance;
        
        for(int i: e.subordinates)
            result += dfs(i);
        
        return result;
    }
}