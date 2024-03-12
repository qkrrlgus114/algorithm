import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        int N = Integer.parseInt(s);

        int[] value = new int[N+1];
        for(int i=1; i <= N; i++){
            s = bf.readLine();
            value[i] = Integer.parseInt(s);
        }

        int[] sum = new int[N+1];
        for(int i=1; i<=N; i++){
            sum[i] = sum[i-1] + value[i];
        }

        int result = 0;
        for(int i=1; i<=N/2+1; i++){
            if(i+1 > N) break;
            for(int j=i+1; j<=N; j++){
                int temp = Math.min(sum[j-1] - sum[i-1], sum[N] - sum[j-1] + sum[i-1]);
                result = Math.max(result, temp);
            }
        }

        System.out.println(result);
    }

}