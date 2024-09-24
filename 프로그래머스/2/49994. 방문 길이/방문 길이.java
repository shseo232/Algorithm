import java.util.*;
class Solution {
    public int solution(String dirs) {
        int answer = 0;
        
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        
        int x = 5;
        int y = 5;
        
        Set<String> set = new HashSet();
        for(int i=0; i<dirs.length(); i++){
            Character c = dirs.charAt(i);
            int nx =0;
            int ny =0;
            
            if(c == 'U'){
                 nx = x + dx[0];
                 ny = y + dy[0];
            }
            else if(c == 'D'){
                 nx = x + dx[1];
                 ny = y + dy[1];                
            }
            else if(c == 'R'){
                 nx = x + dx[2];
                 ny = y + dy[2];
            }
            else if(c == 'L'){
                 nx = x + dx[3];
                 ny = y + dy[3];
            }
            
            if(0<=nx && nx<11 && 0<=ny && ny<11){
                set.add(x + " " + y + " " + nx + " " + ny);
                set.add(nx + " " + ny + " " + x + " " + y);
                x = nx;
                y = ny;
            }else{
                continue;
            }
        }
        return set.size() / 2;
    }
}