import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int N = Integer.parseInt(s);
        s = bf.readLine();
        int K = Integer.parseInt(s);

        int l = 0;
        int r = K;
        int answer = 0;

        while(l <= r){
            int mid = (l + r) / 2;
            int count = 0;

            for(int i=1; i<=N; i++){
                count += Math.min(mid / i, N);
            }

            if(K <= count){
                answer = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        System.out.println(answer);
    }

}

