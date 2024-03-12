import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);

        Integer[] arr = new Integer[N+M];

        sa = bf.readLine().split(" ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(sa[i]);
        }
        sa = bf.readLine().split(" ");
        for(int i=N; i<N+M; i++){
            arr[i] = Integer.parseInt(sa[i-N]);
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for(Integer i : arr){
            sb.append(i).append(" ");
        }

        System.out.println(sb);

    }

}