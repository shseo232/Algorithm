import java.util.*;
class Solution {
    static int[] count = {0,0,0};
    public List<Integer> solution(int[] answers) {
        int[] answer = {};
        int[] player1 = {1,2,3,4,5};
        int[] player2 = {2,1,2,3,2,4,2,5};
        int[] player3 = {3,3,1,1,2,2,4,4,5,5};
        List<int[]> arr = Arrays.asList(player1, player2, player3);
        for(int i=0; i<arr.size(); i++){
            answerCheck(i,arr.get(i),answers);
        }
        int max = Math.max(count[0],Math.max(count[1],count[2]));
        ArrayList<Integer>list = new ArrayList<>();
        for(int i=0; i< count.length; i++){
            if(max == count[i]){
                list.add(i+1);
            }
        }
        return list;
    }
    
    static void answerCheck(int index, int[] player, int[] answers) {
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == player[i % player.length]) {
                count[index]++;
            }
        }
    }
}