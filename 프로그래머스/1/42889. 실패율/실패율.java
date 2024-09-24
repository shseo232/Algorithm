import java.util.*;

class Solution {
    public List<Integer> solution(int N, int[] stages) {
        List<Integer> answer = new ArrayList();
        Arrays.sort(stages);
        List<Map<Integer,Double>> list = new ArrayList();
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
            Map<Integer,Double> map = new HashMap();
            if(player == 0.0){
                map.put(i+1, 0.0);
            }else{
                map.put(i+1,count/player);
            }
            
            list.add(map);
        }
        list.sort((m1, m2) -> {
            Double value1 = m1.values().iterator().next(); 
            Double value2 = m2.values().iterator().next(); 
            return value2.compareTo(value1); // 내림차순 비교
        });

        for (Map<Integer, Double> map : list) {
            Integer key = map.keySet().iterator().next(); 
            answer.add(key); 
        }
            return answer;
    }
}