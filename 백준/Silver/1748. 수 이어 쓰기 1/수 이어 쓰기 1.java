import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Long[] array = new Long[10];
        array[0] = 0L;
        for(int i=1; i<array.length; i++){
            array[i] = (long) (9 * (Math.pow(10, i-1)));
        };

        String T = bf.readLine();
        int L = T.length();
        int sum = 0;

        Long result = Long.parseLong(T);
        if(result < 10){
            System.out.println(result);
        }else{
            for(int i=1; i<L; i++){
                result -= array[i];
                sum += array[i] * i;
            }
            sum += result * L;
            System.out.println(sum);
        }

    }
}
