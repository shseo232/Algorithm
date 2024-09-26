import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        Queue<String> card1 = new LinkedList();
        Queue<String> card2 = new LinkedList();
        
        for(int i=0; i<cards1.length; i++){
            card1.offer(cards1[i]);
        }
        
        for(int i=0; i<cards2.length; i++){
            card2.offer(cards2[i]);
        }
        
        String word1 = card1.poll();
        String word2 = card2.poll();
        
        for(int i=0; i<goal.length; i++){
            String word = goal[i];
            
            if(word.equals(word1)){
                word1 = card1.poll();
            }
            else if(word.equals(word2)){
                word2 = card2.poll();
            }else{
                answer = "No";
                break;
            }
        }
        if(answer.equals("")){
            answer ="Yes";
        }
        
        return answer;
    }
}