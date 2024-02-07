import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");

        int N = Integer.parseInt(sa[0]);
        int K = Integer.parseInt(sa[1]);
        int[] arr = new int[N];

        sa = bf.readLine().split(" ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(sa[i]);
        }

        // 누적합 배열
        int[] sum_arr = new int[N+1];
        sum_arr[1] = arr[0];

        for(int i=1; i<N; i++){
            sum_arr[i+1] = sum_arr[i] + arr[i];
        }

        // 최대값
        int result = Integer.MIN_VALUE;
        for(int i=0; i <= arr.length - K; i++){
            if(result < sum_arr[i+K] - sum_arr[i]){
                result = sum_arr[i+K] - sum_arr[i];
            }
        }

        System.out.println(result);

    }

}