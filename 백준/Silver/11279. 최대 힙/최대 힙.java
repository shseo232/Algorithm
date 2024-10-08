import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            if(pq.isEmpty() && num == 0){
                sb.append(0);
                sb.append("\n");
            }else{
                if(num == 0){
                    sb.append(pq.poll());
                    sb.append("\n");
                }else{
                    pq.add(num);
                }

            }
        }
        System.out.print(sb);
    }
}
