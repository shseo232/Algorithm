import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] splitMin = s.split("-");
        int result = 0;
        for (int i = 0; i < splitMin.length; i++) {
            String[] splitPlus  = splitMin[i].split("\\+");
            int total =0;
            for (int j = 0; j < splitPlus.length; j++) {
                total += Integer.parseInt(splitPlus[j]);
            }
            if(i==0){
                result += total;
            }
            else{
                result -= total;
            }
        }
        System.out.println(result);
    }
}
