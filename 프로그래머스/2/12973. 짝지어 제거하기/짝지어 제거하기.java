import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        Stack<Character> stack = new Stack();
        for(int i=0; i<s.length(); i++){
               // 스택이 비어있지 않고 스택의 최상단 문자와 현재 문자가 같다면 짝지어 제거
            if (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                stack.pop(); // 짝이 맞으면 제거
            } else {
                stack.push(s.charAt(i)); // 그렇지 않으면 스택에 현재 문자를 추가
            }
        }
        
        if(stack.isEmpty()){
            answer = 1;
        }else{
            answer = 0;
        }
        return answer;
    }
}