import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, K;
    static long[] arr;
    static long max = Long.MIN_VALUE;



    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        K = Integer.parseInt(sa[1]);
        arr = new long[N];

        int max_value = 0;

        for(int i=0; i<N; i++){
            String s = bf.readLine();
            arr[i] = Integer.parseInt(s);
            if(max_value < arr[i]) max_value = (int) arr[i];
        }
        binarySearch(1, max_value);

        System.out.println(max);
    }

    public static void binarySearch(long low, long high){
        if(low > high) return;

        long mid = (low + high) / 2;
        long M = 0;

        for(long i : arr){
            M += i/mid;
        }

        if(M >= K){
            max = Math.max(max, mid);
            binarySearch(mid + 1, high);
        }else{
            binarySearch(low, mid - 1);
        }
    }
}
