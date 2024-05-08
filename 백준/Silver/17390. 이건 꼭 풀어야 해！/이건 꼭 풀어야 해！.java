import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int Q = Integer.parseInt(sa[1]);

        int[] arr = new int[N+1];
        sa = bf.readLine().split(" ");
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(sa[i-1]);
        }
        Arrays.sort(arr);

        // 누적합
        for(int i=1; i<=N; i++){
            arr[i] = arr[i-1] + arr[i];
        }


        StringBuilder sb = new StringBuilder();

        for(int q=0; q<Q; q++){
            sa = bf.readLine().split(" ");
            int L = Integer.parseInt(sa[0]);
            int R = Integer.parseInt(sa[1]);

            int num = arr[R] - arr[L - 1];
            sb.append(num).append("\n");
        }

        System.out.println(sb);

    }
}

