import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] mushroom = new int[10];
        for(int i=0; i<10; i++){
            String s = bf.readLine();
            mushroom[i] = Integer.parseInt(s);
        }

        int max = Integer.MIN_VALUE;
        int diffValue = Integer.MAX_VALUE;

        for(int i=0; i<10; i++){
            int sum = 0;
            for(int j=10-i-1; j>=0; j--){
                sum += mushroom[j];
            }
            int value = 100 - sum;

            if(diffValue > Math.abs(value)){
                max = sum;
                diffValue = Math.abs(value);
            }else if(diffValue == Math.abs(value)){
                max = Math.max(max, sum);
            }
        }

        System.out.println(max);
    }
}