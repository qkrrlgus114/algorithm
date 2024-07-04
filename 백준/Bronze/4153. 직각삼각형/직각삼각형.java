import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String[] sa = bf.readLine().split(" ");
            Arrays.sort(sa, (o1 ,o2) -> Integer.parseInt(o1) - Integer.parseInt(o2));
            int a = Integer.parseInt(sa[0]);
            int b = Integer.parseInt(sa[1]);
            int c = Integer.parseInt(sa[2]);

            if(a == 0 && b == 0 && c == 0) break;

            if((c * c) == (a * a) + (b * b)) sb.append("right").append("\n");
            else sb.append("wrong").append("\n");
        }

        System.out.println(sb);

    }

}
