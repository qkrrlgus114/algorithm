import javax.security.auth.login.AccountNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


public class Main {

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);

        int[] cry = new int[M];
        int max = 0;
        for(int i=0; i<M; i++){
            String s = bf.readLine();
            int count = Integer.parseInt(s);
            cry[i] = count;
            max = Math.max(max, count);
        }

        int answer = Integer.MAX_VALUE;
        int start = 1;
        int end = max;

        while(start <= end){
            int mid = (start + end) / 2;

            int sum = 0;
            for(Integer num : cry){
                int people = num % mid == 0 ? num / mid : num / mid + 1;
                sum += people;
            }

            if(sum <= N){
                answer = Math.min(answer, mid);
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        System.out.println(answer);
    }
}

