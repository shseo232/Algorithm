import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int h= sizes.length;
        System.out.print(h);
        int[] arrh = new int[h];
        int[] arrw = new int[h];
        
        for(int i=0; i<h; i++){
            int a = sizes[i][0];
            int b = sizes[i][1];
            if (a>b){
             arrw[i] = a;
             arrh[i] = b;
            }
            else{
             arrw[i] = b;
             arrh[i] = a;
            }
        }
        Arrays.sort(arrw);
        Arrays.sort(arrh);
        answer = arrw[(arrw.length)-1]*arrh[(arrh.length)-1];
        
        return answer;
    }
}