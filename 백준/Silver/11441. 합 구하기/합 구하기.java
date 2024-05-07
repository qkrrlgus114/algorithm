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
        String s = bf.readLine();

        int N = Integer.parseInt(s);
        int[] arr = new int[N+1];

        String[] sa = bf.readLine().split(" ");
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(sa[i-1]);
        }

        // 누적합 구하기
        for(int i=1; i<=N; i++){
            arr[i] = arr[i-1] + arr[i];
        }

        s = bf.readLine();
        int M = Integer.parseInt(s);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            sa = bf.readLine().split(" ");
            int x = Integer.parseInt(sa[0]);
            int y = Integer.parseInt(sa[1]);

            int sum = arr[y] - arr[x-1];

            sb.append(sum).append("\n");
        }

        System.out.println(sb);

    }
}

