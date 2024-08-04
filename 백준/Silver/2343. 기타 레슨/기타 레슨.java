import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer> list = new ArrayList<Integer>();
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int start = 0;
        int end = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
            end += list.get(i);
            start = Math.max(start, list.get(i));
        }
        System.out.print(binarySearch(start,end));

    }
    public static int bluRayCount(int record){
        int sum =0;
        int count=1;
        for (int i=0; i<list.size(); i++){
            sum+=list.get(i);
            if(sum>record){
                sum=list.get(i);
                count++;
            }
        }
        return count;
    }
    public static int binarySearch(int start, int end) {
        while (start < end) {
            int mid = (start+end)/2;
            if(bluRayCount(mid) > m){
                start = mid+1;
            }else{
                end = mid;
            }
        }
        return start;
    }
}
