import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int n;
    static int m;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        dfs(0);
        System.out.print(sb);
    }

    public static void dfs (int depth){
        if(depth == m){
            for(int i : arr){
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1; i<=n; i++){
            arr[depth] = i;
            dfs(depth+1);
        }
    }
}
