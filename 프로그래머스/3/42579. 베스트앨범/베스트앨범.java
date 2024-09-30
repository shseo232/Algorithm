import java.util.*;
 
class Solution {
    public List<Integer> solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
 
        HashMap<String, Integer> num = new HashMap<>(); // 장르별 총 개수
        HashMap<String, HashMap<Integer, Integer>> music = new HashMap<>(); // 장르에 속하는 노래 및 재생횟수
        for(int i = 0; i < plays.length; i++) {
            if(!num.containsKey(genres[i])) {
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);
                music.put(genres[i], map);
                num.put(genres[i], plays[i]);
            } else {
                music.get(genres[i]).put(i, plays[i]);
                num.put(genres[i], num.get(genres[i]) + plays[i]);
            }
        }
 
        List<String> playOrder = new ArrayList(num.keySet());
        Collections.sort(playOrder, (s1, s2) -> num.get(s2) - (num.get(s1)));
 
        for(String key : playOrder) {
            HashMap<Integer, Integer> genre = music.get(key);
            List<Integer> genreKey = new ArrayList(genre.keySet());
 
            Collections.sort(genreKey, (s1, s2) -> genre.get(s2) - (genre.get(s1)));
 
            answer.add(genreKey.get(0));
            if(genreKey.size() > 1)
                answer.add(genreKey.get(1));
        }
 
        return answer;
    }
}