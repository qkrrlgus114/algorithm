import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);

        int[] arr = new int[N];
        sa = bf.readLine().split(" ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(sa[i]);
        }

        int l = 0;
        int r = 0;
        int sum = 0;
        int count = 0;

        while(true){
            if(r > N) break;

            if(sum == M){
                count++;
                l++;
                sum -= arr[l-1];
            }else if(sum < M){
                r++;
                if(r > N) break;
                sum += arr[r-1];
            }else if(sum > M){
                l++;
                sum -= arr[l-1];
            }
        }
        System.out.println(count);

    }
}