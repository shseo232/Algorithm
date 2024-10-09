import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        String s = "";
        double num = 0.0;
        Stack<Double> stack = new Stack<>();
        
        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            if (Character.isDigit(c)) {
                s += c; 
            } else {
                if (!s.isEmpty()) {
                    num = Double.parseDouble(s);
                    s = ""; 
                }
                if (c == 'S') {
                    stack.push(num);
                } else if (c == 'D') {
                    stack.push(Math.pow(num, 2));
                } else if (c == 'T') {
                    stack.push(Math.pow(num, 3));
                } else if (c == '*') {
                    if (stack.size() == 1) {
                        stack.push(stack.pop()*2);
                    }else{
                        Double first = stack.pop()*2;
                        Double second = stack.pop()*2;
                        stack.push(second);
                        stack.push(first);
                    }
                } else if (c == '#') {
                    if (!stack.isEmpty()) {
                        stack.push(stack.pop() * -1);
                    }
                }
            }
        }
        
        while(!stack.isEmpty()){
            answer += stack.pop(); 
        }
        
        return answer;
    }
}
