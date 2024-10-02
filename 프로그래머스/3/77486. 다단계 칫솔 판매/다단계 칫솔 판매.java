import java.util.*;
class Solution {
    static Map<String,Integer> money = new HashMap();
    static Map<String,String> graph = new HashMap();
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        int cost = 100;
        
        for(int i=0; i<enroll.length; i++){
            graph.put(enroll[i],referral[i]);
            money.put(enroll[i],0);
        }
        
        for(int i=0; i<seller.length; i++){
            check(seller[i],(amount[i]*cost));
        }
        for(int i=0; i<enroll.length; i++){
            answer[i] = money.get(enroll[i]);
        }
        return answer;
    }
    static void check(String s,double num){
        if(s.equals("-")){
            return;
        }else{
         double mine = Math.ceil(num*0.9);
         double profit = num*0.1;
         if(profit >= 1){
            money.put(s,money.get(s)+(int)mine);
                      check(graph.get(s),profit);  

          }
         else{
           money.put(s,money.get(s)+(int)num);
         }        
          
        }
        
       
    }
}