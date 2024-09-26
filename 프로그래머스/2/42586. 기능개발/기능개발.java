import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> list = new ArrayList();
        Queue<Integer> q = new LinkedList();
        for(int i=0; i<progresses.length;i++){
            int day = (100 - progresses[i]);
            if(day%speeds[i] == 0){
                q.offer(day/speeds[i]);
            }else{
                q.offer((day/speeds[i])+1);
            }
        }
        while (!q.isEmpty()) {
            int firstDay = q.poll();
            int count = 1; 

            while (!q.isEmpty() && firstDay >= q.peek()) {
                q.poll(); 
                count++;
            }

            list.add(count); 
        }

        answer = list.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}