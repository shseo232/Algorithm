import java.util.*;
class Solution {
    public List<Integer> solution(int[] numbers) {
        int[] answer = {};
        HashSet<Integer> set = new HashSet();
        for(int i=0; i<numbers.length-1; i++){
            for(int j=i+1; j<numbers.length; j++){
                set.add(numbers[i] + numbers[j]);
            }
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        
        return list;
    }
}