import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int max = 0;
        float sum = 0;

        String s = bf.readLine();
        int N = Integer.parseInt(s);

        String[] temp = bf.readLine().split(" ");
        for(String point : temp){
            int intPoint = Integer.parseInt(point);
            if(max < intPoint) max = intPoint;
        }

        for(String point : temp){
            int intPoint = Integer.parseInt(point);
            sum += ((float) intPoint / max) * 100;
        }

        System.out.println(sum / N);
    }
}