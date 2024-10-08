import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0; i<commands.length; i++){
            List<Integer> list = new ArrayList();
            int start = commands[i][0];
            int end = commands[i][1];
            int targetIdx = commands[i][2];
            for(int j=start-1; j<end; j++){
                list.add(array[j]);
            }
            Collections.sort(list);
            answer[i] = list.get(targetIdx-1);
        }
     
        return answer;
    }
}