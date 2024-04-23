import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");

        int N = Integer.parseInt(sa[0]);
        int K = Integer.parseInt(sa[1]);
        int B = Integer.parseInt(sa[2]);
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        for (int i = 0; i < B; i++) {
            String s = bf.readLine();
            arr[Integer.parseInt(s) - 1] = 0;
        }

        int answer = Integer.MAX_VALUE;

        int count = 0;
        for (int i = 0; i <= N - K; i++) {
            count = 0;
            for (int j = i; j < i + K; j++) {
                if (arr[j] == 0) count++;
            }
            answer = Math.min(answer, count);
        }

        System.out.println(answer);
    }
}

