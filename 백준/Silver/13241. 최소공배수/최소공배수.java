import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        long y = Integer.parseInt(st.nextToken());
        long gcd = gcd(x, y);
        long answer = x*y/gcd;
        System.out.println(answer);

    }
    public static long gcd (long x, long y){
        if(y == 0) {return x;}
        return gcd(y, x%y);
    }
}
