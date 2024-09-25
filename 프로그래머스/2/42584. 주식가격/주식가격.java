import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack();
        for(int i=0; i <prices.length-1;i++){
            stack.push(prices[i]);
            for(int j=i+1; j< prices.length; j++){
                if(stack.peek() > prices[j]){
                    answer[i] = j-i;
                    stack.pop();
                    break;
                }
            }
            if(!stack.isEmpty()){
                answer[i] = prices.length-(i+1);
                stack.pop();
          
            }
        }
        answer[prices.length-1] =0;
        return answer;
    }
}