import java.util.*;
class Solution {
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static List<Integer> list = new ArrayList();
    static int answer = 0;
    public int solution(int[][] maps) {
        int width = maps[0].length;
        int height = maps.length;
        visited = new boolean[height][width];
        bfs(maps,width,height);
        if(answer == 0){
            return -1;
        }
        return answer;
    }
    public static void bfs(int[][] maps,int width, int height){
        Queue<int[]> q = new LinkedList();
        int[] temp = new int[3];
        temp[0] = 0;
        temp[1] = 0;
        temp[2] = 1;
        q.add(temp);
        visited[0][0] = true;
        while(!q.isEmpty()){
            int[] temp1 = q.poll();
            int x = temp1[0];
            int y = temp1[1];
            int d = temp1[2];
            for(int i=0; i<4; i++){
                int currentX = x + dx[i];
                int currentY = y + dy[i];
                if(currentX >=0 && currentY >=0 && currentX < width && currentY < height){
                    if(maps[currentY][currentX] == 1 && visited[currentY][currentX] == false){
                        visited[currentY][currentX] = true;
                        if(currentX == width-1 &&  currentY == height-1){
                            answer = d+1;
                        }
                        int[] temp2 = new int[3];
                        temp2[0] = currentX;
                        temp2[1] = currentY;
                        temp2[2] = d+1;
                        q.add(temp2);
                    }
                }
            }
        }
    }
}