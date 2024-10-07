import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr,(s1,s2)->{
            if(s2[0] - s1[0] == 0){
                return s1[1] - s2[1];
            }else{
                return s1[0] - s2[0];
            }
        });
        for (int i = 0; i < N; i++) {
            sb.append(arr[i][0] +" "+ arr[i][1] + "\n");
        }
        System.out.println(sb);
    }
}
