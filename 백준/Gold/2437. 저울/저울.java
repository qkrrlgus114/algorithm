import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        int N = Integer.parseInt(s);

        int[] arr = new int[N];
        String[] sa = bf.readLine().split(" ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(sa[i]);
        }

        Arrays.sort(arr);

        int sum = 1;
        for(int i=0; i<N; i++){
            if(sum >= arr[i]) sum += arr[i];
            else break;
        }

        System.out.println(sum);
    }
}

