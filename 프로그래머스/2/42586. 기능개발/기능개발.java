import java.util.*;
class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> list = new ArrayList();
        Queue<Integer> q = new LinkedList();
        for(int i =0; i<speeds.length; i++){
            if((100-progresses[i])%speeds[i] == 0){
                q.add((100-progresses[i])/speeds[i]);
            }else{
                q.add(((100-progresses[i])/speeds[i]) +1);
            }
        }
        
        System.out.print(q);
        while(!q.isEmpty()){
            int num = q.poll();
            int count = 1;
            while(!q.isEmpty() && num >= q.peek()){
                q.poll();
                count++;
            }
            list.add(count);
        }
        System.out.print(list);
        return list;
    }
}