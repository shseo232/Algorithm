import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    static boolean[] visited;
    static boolean found = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // 노드들 먼저 넣음
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.get(a).add(b);
            map.get(b).add(a);
        }

        visited = new boolean[n];
        for (int i : map.keySet()) {
            if (!visited[i]) {
                dfs(i, 1);
                if (found) break;  // 조건 만족 시 즉시 종료
            }
        }

        System.out.println(found ? 1 : 0);
    }

    public static void dfs(int i, int depth) {
        if (found) return;  // 이미 조건이 만족되면 더 이상 탐색할 필요 없음

        if (depth == 5) {
            found = true;
            return;
        }

        visited[i] = true;
        for (int j : map.get(i)) {
            if (!visited[j]) {
                dfs(j, depth + 1);
            }
        }
        visited[i] = false;  // 방문 상태 복원
    }
}
