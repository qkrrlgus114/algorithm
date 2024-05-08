import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);

        long[] arr = new long[N+1];
        sa = bf.readLine().split(" ");
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(sa[i-1]);
        }

        // 누적합
        for(int i=1; i<=N; i++){
            arr[i] = arr[i-1] + arr[i];
        }


        int l = 1;
        int r = M;
        long answer = 0;

        while(r <= N){
            answer = Math.max(answer, arr[r] - arr[l-1]);

            l++;
            r++;
        }

        System.out.println(answer);

    }
}

