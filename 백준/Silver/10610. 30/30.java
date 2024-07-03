import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        char[] c = new char[s.length()];
        c = s.toCharArray();
        Arrays.sort(c);

        // 10의 배수인지 먼저 판정
        if(c[0] != '0') System.out.println(-1);
        else{
            StringBuilder sb = new StringBuilder();
            int value = 0;
            for(int i=c.length - 1; i>=0; i--){
                sb.append(c[i]);
                value += c[i] - '0';
            }
            if(value % 3 == 0) System.out.println(sb.toString());
            else System.out.println(-1);
        }
    }

}
