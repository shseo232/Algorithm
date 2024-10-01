import java.util.*;

class Solution {
    public List<Integer> solution(int N, int[] stages) {
        List<Integer> answer = new ArrayList();
        Arrays.sort(stages);
        Map<Integer,Double> map = new HashMap();
        for(int i =0; i<N; i++){
            int stage = i+1;
            Double player = 0.0;
            Double count =0.0;
            for(int j=0; j<stages.length; j++){
                if(stage <= stages[j]){
                    player++;
                    if(stage == stages[j]){
                        count++;
                    }
                }
            }

            if(player == 0.0){
                map.put(i+1, 0.0);
            }else{
                map.put(i+1,count/player);
            }
            
        }
        // System.out.print(map);
        List<Integer> list = new ArrayList(map.keySet());
        Collections.sort(list,(s1,s2)->{
            Double value1 = map.get(s1);
            Double value2 = map.get(s2);
            return Double.compare(value2, value1);
        });
            System.out.print(list);
        answer = list;
            return answer;
    }
}