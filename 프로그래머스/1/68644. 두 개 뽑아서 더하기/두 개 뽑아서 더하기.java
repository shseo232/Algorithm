import java.util.*;
class Solution {
    public List<Integer> solution(int[] numbers) {
        Arrays.sort(numbers);
        HashSet<Integer> set = new HashSet();
        for(int i=0; i<numbers.length;i++){
            for(int j=0; j<numbers.length;j++){
                if(i == j){
                    continue;
                }
                int sum = numbers[i]+numbers[j];
                set.add(sum);
            }
        }
        List<Integer> list = new ArrayList(set);
        Collections.sort(list);
        return list;
    }
}