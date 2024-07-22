import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        sb.append(gcd(x, y)).append('\n');
        sb.append(x*y/gcd(x, y)).append('\n');
        System.out.println(sb);
    }
    public static int gcd (int x, int y){
        if(y == 0) {return x;}
        return gcd(y, x%y);
    }
}
