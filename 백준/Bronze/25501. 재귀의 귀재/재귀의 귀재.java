import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int count = 0;
    static int num = 0;

    public static void check(String str, int start, int end) {
        count++;
        if (start >= end) {
            num = 1; 
            return;
        } else if (str.charAt(start) != str.charAt(end)) {
            num = 0;
            return;
        } else {
            check(str, start + 1, end - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            count = 0;
            check(s, 0, s.length() - 1);
            System.out.println(num +" " + count);
        }
    }
}
