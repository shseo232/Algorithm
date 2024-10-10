import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        List<Integer> list = new ArrayList();
        Queue<Map<Integer,Integer>> q = new LinkedList();
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        for(int i=0; i<priorities.length; i++){
            Map<Integer,Integer> map = new HashMap();
            map.put(i,priorities[i]);
            q.add(map);
            pq.add(priorities[i]);
        }
        
        while(!q.isEmpty()){
            if(q.peek().containsValue(pq.peek())){
                pq.poll();
                answer++;
                if(q.poll().containsKey(location)){
                    break;
                }
                // list.add(q.poll().keySet().iterator().next());
            }else{
                q.add(q.poll());
            }
        }
        
        return answer;
        
    }
}