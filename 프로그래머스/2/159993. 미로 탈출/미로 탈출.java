import java.util.*;

class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static char[][] c;

    public int solution(String[] maps) {
        int rows = maps.length;
        int cols = maps[0].length();
        c = new char[rows][cols];

        int startX = 0, startY = 0;
        int leverX = 0, leverY = 0;

        for (int i = 0; i < rows; i++) {
            char[] temp = maps[i].toCharArray();
            for (int j = 0; j < cols; j++) {
                c[i][j] = temp[j];
                if (c[i][j] == 'S') {
                    startY = i;
                    startX = j;
                } else if (c[i][j] == 'L') {
                    leverY = i;
                    leverX = j;
                }
            }
        }

        int timeToLever = bfs(startY, startX, 'L', rows, cols, true);
        if (timeToLever == -1) return -1; 

        int timeToExit = bfs(leverY, leverX, 'E', rows, cols, false);
        if (timeToExit == -1) return -1; 

        return timeToLever + timeToExit;
    }

    static int bfs(int y, int x, char target, int rows, int cols, boolean allowExit) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        q.add(new int[]{y, x, 0});
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int cy = pos[0];
            int cx = pos[1];
            int time = pos[2];

            if (c[cy][cx] == target) return time;

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny >= 0 && nx >= 0 && ny < rows && nx < cols &&
                    (c[ny][nx] == 'O' || c[ny][nx] == target || (allowExit && c[ny][nx] == 'E') || (!allowExit && c[ny][nx] == 'S')) && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    q.add(new int[]{ny, nx, time + 1});
                }
            }
        }
        return -1;
    }
}
