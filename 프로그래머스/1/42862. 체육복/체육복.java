import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        Set<Integer> set = new HashSet();
        for(int i=0; i<reserve.length; i++){
            set.add(reserve[i]);
        }
        List<Integer> list = new ArrayList();
        for(int i=0; i<lost.length; i++){
            if(set.contains(lost[i])){
                set.remove(lost[i]);
            }else{
                list.add(lost[i]);
            }
        }
        Collections.sort(list);
        int count =0;
        for(int i=0; i<list.size(); i++){
            if(set.contains(list.get(i)-1)){
                set.remove(list.get(i)-1);
            }
            else if(set.contains(list.get(i)+1)){
                set.remove(list.get(i)+1);
            }
            else{
                count++;
            }
        }
        
        return answer-count;
    }
}