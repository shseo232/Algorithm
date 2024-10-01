import java.util.*;

class Solution {
    public ArrayList solution(String[] genres, int[] plays) {
        //속한 노래가 많이 재생된 장르 -> 장르 내에서 재생된 노래 -> 재생 횟수가 같으면 고유 번호가 낮은 노래
        int len = genres.length;
        HashMap<String, Integer> cntMap = new HashMap<>(); //전체 재생 횟수를 구하기 위함
        HashMap<String, ArrayList<int[]>> map = new HashMap<>(); //장르, <재생횟수, 고유번호> 
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int i=0; i<len; i++){ 
            if(cntMap.containsKey(genres[i])){
                cntMap.put(genres[i], cntMap.get(genres[i])+plays[i]);
            }else{
                cntMap.put(genres[i], plays[i]);
            }
        }
        
        for (int i=0; i<len; i++) {
            if (!map.containsKey(genres[i])) { //키가 없으면
                map.put(genres[i], new ArrayList<int[]>()); //빈 배열 생성 -> 이 과정을 안해주면 NullPointerException 발생
            }
            map.get(genres[i]).add(new int[]{plays[i], i}); //재생 횟수, 고유 번호 저장
        }
        
        //cntMap을 value값을 기준으로 정렬
        ArrayList<String> list = new ArrayList<>(cntMap.keySet());
        Collections.sort(list, (s1,s2) -> {
            int value1 = cntMap.get(s1);
            int value2 = cntMap.get(s2);
            return value2 -  value1; //내림차순 정렬
        });
        
        for(int i=0; i<list.size(); i++){
            ArrayList<int[]> songs = map.get(list.get(i)); //values에 대해 새로운 배열 생성
            Collections.sort(songs, new Comparator<int[]>(){
                @Override
                public int compare(int[] song1, int[] song2) {
                    if (song1[0] == song2[0]) {
                        return song1[1] - song2[1]; //고유번호 기준 오름차순
                    }
                    return song2[0] - song1[0]; //재생횟수 기준 내림차순
                }
            });
            for (int j=0; j<songs.size(); j++) {
                if (j >= 2) {
                    break;
                }
                answer.add(songs.get(j)[1]);
            }
        }

        return answer;
    }
}