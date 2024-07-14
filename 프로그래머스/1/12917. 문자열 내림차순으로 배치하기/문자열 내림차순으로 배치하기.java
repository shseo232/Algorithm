import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        List<Character> list = new ArrayList();
        for(int i=0; i< s.length(); i++){
            list.add(s.charAt(i));
        }
        Collections.sort(list,Collections.reverseOrder());
        for(int i=0; i<list.size(); i++){
            sb.append(list.get(i));
        }
        System.out.print(sb);
        answer = sb.toString();
        return answer;
    }
}