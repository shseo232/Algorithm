import java.util.*;
class Solution {
    static List<Integer> visited;
    static Map<Integer,List<Integer>> graph; 
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new ArrayList();
        graph = new HashMap();
        
        for(int i=1; i<=n; i++){
            graph.put(i,new ArrayList<Integer>());
        }
        for(int i=0; i< computers.length; i++){
            for(int j=0; j<computers[0].length; j++){
                if(i != j && computers[i][j] == 1){
                    graph.get(i+1).add(j+1);
                }
            }
        }
    
        for(int i : graph.keySet()){
            if(!visited.contains(i)){
                dfs(i);
                answer++;
            }
            }
        System.out.print(graph);
        return answer;
    }
    static void dfs(int num){
        List<Integer> list = graph.get(num);
        visited.add(num);
        for(int i : list){
            if(!visited.contains(i)){
                dfs(i);
                visited.add(i);
            }
        }
    }
}