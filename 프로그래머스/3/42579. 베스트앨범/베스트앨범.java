import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList();
        Map<String,Integer> count = new HashMap();
        Map<String,Map<Integer,Integer>> music = new HashMap();
        for(int i=0; i<genres.length; i++){
            count.put(genres[i],count.getOrDefault(genres[i],0)+plays[i]);
            if(!music.containsKey(genres[i])){
                Map<Integer,Integer> map = new HashMap();
                map.put(i,plays[i]);
                music.put(genres[i],map);
            }else{
                music.get(genres[i]).put(i,plays[i]);
            }
        }
        List<String> list = new ArrayList(count.keySet());
        Collections.sort(list,(s1,s2)->{
            int value1 = count.get(s1);
            int value2 = count.get(s2);
            return value2 - value1;
        });
        for(String key : list){
            Map<Integer,Integer> map = music.get(key);
            List<Integer> indexList = new ArrayList(map.keySet()); // 1, 4 / 0, 2, 3
            Collections.sort(indexList,(s1,s2)->{
                int value1 = map.get(s1);
                int value2 = map.get(s2);
                return value2 - value1;
            });
            answer.add(indexList.get(0));
            if(indexList.size()>1){
                answer.add(indexList.get(1));
            }
             
        }
        return answer.stream().mapToInt(i -> i).toArray(); // int 배열로 변환 후 반환
    }
}