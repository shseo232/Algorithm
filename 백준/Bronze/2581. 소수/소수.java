
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        decimal(M, N);
    }

    public static void decimal(int M, int N) {
        int Min =0;
        int Sum =0;
        
        for (int i = M; i <= N; i++) {
            boolean flag = true;
            if (i < 2) {
                flag = false;
            }
            for (int j = 2; j <= (int)Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                if(Min==0){
                    Min = i;
                }
                Sum += i;
            }
        }
        if(Min==0){
            System.out.println(-1);
        }else {
            System.out.println(Sum);
            System.out.println(Min);
        }
    }
}
