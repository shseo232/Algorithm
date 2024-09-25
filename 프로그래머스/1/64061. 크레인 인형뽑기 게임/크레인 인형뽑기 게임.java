import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int move : moves) {
            int column = move - 1;
            for (int row = 0; row < board.length; row++) {
                if (board[row][column] != 0) {
                    int pickedDoll = board[row][column];
                    board[row][column] = 0;
                    if (!stack.isEmpty() && stack.peek() == pickedDoll) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(pickedDoll);
                    }
                    break;
                }
            }
        }
        return answer;
    }
}
