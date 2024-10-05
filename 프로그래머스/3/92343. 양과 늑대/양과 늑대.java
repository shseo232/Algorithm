import java.util.*;
class Solution {
    static Map<Integer,List<Integer>> map = new HashMap();
    static Map<Integer,Integer> infos = new HashMap();
    static int maxSheep = 0;
    
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        for(int i=0; i<edges.length; i++){
            if(map.containsKey(edges[i][0])){
                map.get(edges[i][0]).add(edges[i][1]);
            }else{
                List<Integer> list = new ArrayList();
                list.add(edges[i][1]);
                map.put(edges[i][0],list);
            }
        }
        
        for(int i=0; i<info.length; i++){
            infos.put(i,info[i]);
        }        
        List<Integer> nextNodes = new ArrayList<>();
        nextNodes.add(0);  // 루트 노드 추가
        dfs(0, 0, 0, nextNodes);  // 초기에는 양과 늑대 수 0으로 시작

        return maxSheep;
    }
    private void dfs(int current, int sheep, int wolf, List<Integer> nextNodes) {
        // 현재 노드에 있는 동물 정보에 따라 양/늑대 수 업데이트
        if (infos.get(current) == 0) {
            sheep++;
        } else {
            wolf++;
        }

        // 늑대 수가 양 수와 같거나 많아지면 탐색 중단 (양이 잡아먹히는 경우)
        if (wolf >= sheep) {
            return;
        }

        // 최대 양의 수 갱신
        maxSheep = Math.max(maxSheep, sheep);

        // 현재 상태에서 탐색 가능한 노드 리스트를 새로 생성 (상태 복사)
        List<Integer> newNextNodes = new ArrayList<>(nextNodes);
        newNextNodes.remove(Integer.valueOf(current));  // 현재 노드는 리스트에서 제거

        // 현재 노드에서 갈 수 있는 자식 노드를 탐색 가능한 리스트에 추가
        if (map.containsKey(current)) {
            newNextNodes.addAll(map.get(current));
        }

        // 다음 가능한 노드들에 대해 재귀적으로 탐색
        for (int next : newNextNodes) {
            dfs(next, sheep, wolf, newNextNodes);
        }
    }
}