import java.util.*;
class Solution {
    public List<String> solution(String[] record) {
        List<String> answer = new ArrayList();
        List<String> list = new ArrayList();
        Map<String,String> map = new HashMap();
        for(int i=0; i<record.length; i++){
            String[] split = record[i].split(" ");
            for(int j=0; j<split.length; j++){
                if(split[j].equals("Enter")){
                    map.put(split[j+1],split[j+2]);
                    list.add(split[j+1]+"님이 들어왔습니다.");
                }else if(split[j].equals("Leave")){      
                    if(map.containsKey(split[j+1])){
                        list.add(split[j+1]+"님이 나갔습니다.");
                    }
                }else if(split[j].equals("Change")){
                   map.put(split[j+1],split[j+2]);
                }
            }
        }
          for (String s : list) {
            String id = s.substring(0, s.indexOf("님"));
            String nick = s.replace(id, map.get(id));
            answer.add(nick);
        }
        
        return answer;
    }
}