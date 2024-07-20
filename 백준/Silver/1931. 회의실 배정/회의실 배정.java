import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(arr, (o1,o2)->{
            if(o2[1] == o1[1]){
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        int time = 0;
        int count = 0;
        for (int i = 0; i < N; i++) {
            if(time <= arr[i][0]){
                time = arr[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}