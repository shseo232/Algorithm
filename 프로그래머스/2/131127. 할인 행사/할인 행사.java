import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String,Integer> wantList = new HashMap();
        
        for(int i=0; i<want.length;i++){
            wantList.put(want[i],number[i]);
        }
        
       for(int i =0; i<=discount.length-10;i++){
           Map<String,Integer> map = new HashMap();
           for(int j=i; j<i+10; j++){
               if(map.containsKey(discount[j])){
                map.put(discount[j],map.get(discount[j])+1);
                }else{
                   map.put(discount[j],1);
               }
           }
          
           boolean check = true;
            for(String s : wantList.keySet()){
                    if(!map.containsKey(s) || map.get(s) < wantList.get(s)){
                        check = false;
                        break;
                    }
            }
           
            if(check){
                answer++;
            }
           
       }
        
        return answer;
    }
}