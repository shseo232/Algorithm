import java.util.*;

class Solution {
    static List<int[]> list = new ArrayList();
    public static void move(int n,int from, int to){
        if(int n ==1){
            list.add(new int[] {from,to});
            return;
        }
        
        int empty = 6 - from - to;
        move(n-1,from,empty);
        move(1,from,to);
        move(n-1,empty,to);
    
    }
    public List<int[]> solution(int n) {
        move(n,1,3);
        return list;
    }
}