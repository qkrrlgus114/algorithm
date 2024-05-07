import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");

        int N = Integer.parseInt(sa[0]);
        int X = Integer.parseInt(sa[1]);
        int[] arr = new int[N+1];

        sa = bf.readLine().split(" ");
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(sa[i-1]);
        }

        // 누적합 구하기
        for(int i=1; i<=N; i++){
            arr[i] = arr[i-1] + arr[i];
        }

        int count = 1;
        int answer = 0;

        for(int i=X; i<=N; i++){
            int sum = arr[i] - arr[i-X];
            if(sum == answer) count++;
            else if(sum > answer){
                answer = sum;
                count = 1;
            }
        }

        if(answer == 0){
            System.out.println("SAD");
        }else{
            System.out.println(answer);
            System.out.println(count);
        }

    }
}

