import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String,List<String>> reportList = new HashMap();
        Map<String,Integer> userCount = new HashMap();
        
        for(int i=0; i<id_list.length; i++){
            reportList.put(id_list[i],new ArrayList<String>());
            userCount.put(id_list[i],0);
        }
        
        for(int i=0; i<report.length; i++){
            String[] split = report[i].split(" ");
            //중복 신고 방지하기 위해
            if(!reportList.get(split[0]).contains(split[1])){
                reportList.get(split[0]).add(split[1]);
                userCount.put(split[1],userCount.get(split[1])+1);
            }
        }
        for(int i=0; i<id_list.length; i++){
             List<String> temp = reportList.get(id_list[i]);
             for(String s : userCount.keySet()){
                 if(temp.contains(s) && userCount.get(s)>=k){
                     answer[i]++;
                 }
             }
        }
        return answer;
    }
}
