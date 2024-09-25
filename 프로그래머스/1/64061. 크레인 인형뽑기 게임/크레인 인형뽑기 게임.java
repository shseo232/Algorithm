import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack();
        for(int i=0; i< moves.length; i++){
            int pick = moves[i]-1;
            for(int j=0; j<board.length;j++){
                if(board[j][pick] != 0){
                    if(!stack.isEmpty() && stack.peek() == board[j][pick]){
                        stack.pop();
                        board[j][pick] = 0;   
                        answer+=2;                        
                        break;
                    }
                    stack.push(board[j][pick]);
                    board[j][pick] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}