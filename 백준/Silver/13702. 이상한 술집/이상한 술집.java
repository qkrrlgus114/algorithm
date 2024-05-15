import javax.security.auth.login.AccountNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int K = Integer.parseInt(sa[1]);

        int[] arr = new int[N];
        int max = 0;
        for(int i=0; i<N; i++){
            String s = bf.readLine();
            arr[i] = Integer.parseInt(s);
            max = Math.max(max, arr[i]);
        }

        long l = 1;
        long r = max;
        long answer = 0;

        while(l <= r){
            long mid = (l + r) / 2;
            // 나눠줄 수 있는 인원의 수
            long count = 0;

            for(int drink : arr){
                count += drink / mid;
            }

            if(count >= K){
                answer = mid;
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }

        System.out.println(answer);

    }
}

