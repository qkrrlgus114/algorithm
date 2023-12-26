import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[5];
        int sum = 0;
        for(int i=0; i<5; i++){
            String s = bf.readLine();
            arr[i] = Integer.parseInt(s);
            sum += arr[i];
        }

        Arrays.sort(arr);
        System.out.println((int) sum / 5);
        System.out.println(arr[2]);
    }
}