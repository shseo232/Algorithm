import java.util.*;

class Solution {
    static boolean[] visited;
    static Map<Integer, List<Integer>> map = new HashMap<>();
    static int[] distance;

    public int solution(int n, int[][] edge) {
        // 그래프 초기화
        for (int i = 1; i <= n; i++) {
            map.put(i, new ArrayList<>());
        }
        visited = new boolean[n + 1];
        distance = new int[n + 1];
        
        // 간선 정보 추가
        for (int[] a : edge) {
            map.get(a[0]).add(a[1]);
            map.get(a[1]).add(a[0]);
        }
        
        // BFS 실행
        bfs(1);

        // 가장 멀리 있는 노드들의 개수를 계산
        int maxDistance = 0;
        int answer = 0;
        for (int dist : distance) {
            if (dist > maxDistance) {
                maxDistance = dist;
                answer = 1;
            } else if (dist == maxDistance) {
                answer++;
            }
        }
        
        return answer;
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        distance[start] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : map.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    distance[neighbor] = distance[node] + 1;
                }
            }
        }
    }
}
