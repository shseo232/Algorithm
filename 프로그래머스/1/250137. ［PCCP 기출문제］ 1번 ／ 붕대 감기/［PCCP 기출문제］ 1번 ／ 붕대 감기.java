import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];
        int Max = health;
        int count = 0;
        Map<Integer,Integer> map = new HashMap();
        for(int i=0; i<attacks.length; i++){
            map.put(attacks[i][0],attacks[i][1]);
        }

        for(int i=0; i<=attacks[attacks.length-1][0]; i++){
            if(map.containsKey(i)){
                if( health - map.get(i) <= 0){
                    return -1;
                }
                health -= map.get(i);
                count = 0;
            }else{
                health+=x;
                count++;
                if(count == t){
                    health+=y;
                    count = 0;
                }
                if(health > Max){
                    health = Max;
                }
            }
        }
        answer = health;
        return answer;
    }
}