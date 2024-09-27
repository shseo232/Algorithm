import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        
        // 완주한 사람들의 이름을 카운팅
        for (String s : completion) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        
        // 참가자 목록에서 완주하지 못한 사람 찾기
        for (String s : participant) {
            // map에서 참가자를 찾고, 있으면 count를 줄임
            if (map.containsKey(s)) {
                map.put(s, map.get(s) - 1);
                if (map.get(s) == 0) {
                    map.remove(s);  // count가 0이 되면 제거
                }
            } else {
                answer = s;  // map에 없는 사람이 완주하지 못한 사람
                break;
            }
        }
        
        return answer;
    }
}
