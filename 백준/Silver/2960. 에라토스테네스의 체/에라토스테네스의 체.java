

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            decimal(M, N);
        }

        public static void decimal(int M, int N) {
            int count =0;
            List<Integer> visited = new ArrayList<Integer>();
            for (int i = 2; i <= M; i++) {
                for (int j = 1; j*i <= M; j++) {
                    if(visited.contains(j*i)) {
                        continue;
                    }else{
                        visited.add(i*j);
                    }
                    count++;
                    if(count == N){
                        System.out.println(i*j);
                        return;
                    }
                }
            }
        }
    }

