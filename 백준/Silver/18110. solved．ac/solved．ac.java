import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if(N == 0) System.out.println(0);
        else{
            int[] arr = new int[N];
            int sum = 0;
            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(arr);

            int value = (int) Math.round(N * 0.15);

            int count = 0;
            for(int i=value; i<N-value; i++){
                count++;
                sum += arr[i];
            }

            System.out.println(Math.round((double) sum / count));
        }
    }
}
