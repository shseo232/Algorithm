import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long X = Integer.parseInt(st.nextToken());
        long Y = Integer.parseInt(st.nextToken());
        int Z = (int) (((double) Y * 100 / X));

        if (Z >= 99) {
            System.out.println(-1);
            return;
        }

        // System.out.println(Z);
        long newY = binarySearch(Z, X, Y, 0, X);
        System.out.println(newY);
    }

    static long result = -1;
    static long binarySearch(int Z, long X, long Y, long min, long max) {

        if (min > max) {
            return result;
        }
        long mid = (min + max) / 2;
        int newZ = (int) (((double) ((mid + Y) * 100) / (mid + X)));
        if (Z < newZ) {
            result = mid;
            max = mid - 1;
        } else {
            min = mid + 1;
        }

        // 줄어든 범위를 다시 재귀호출로 탐색
        return binarySearch(Z, X, Y, min, max);
    }
}
