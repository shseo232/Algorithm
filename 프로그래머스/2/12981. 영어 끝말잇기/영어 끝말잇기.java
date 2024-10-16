import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>();
        set.add(words[0]); 

        for (int i = 1; i < words.length; i++) {
            char lastChar = words[i-1].charAt(words[i-1].length() -1);
            char firstChar = words[i].charAt(0);
            if (lastChar != firstChar || set.contains(words[i])) {
                answer[0] = (i % n) + 1;    
                answer[1] = (i / n) + 1;         
                return answer;
            }
            set.add(words[i]);
        }
        return answer;
    }
}
