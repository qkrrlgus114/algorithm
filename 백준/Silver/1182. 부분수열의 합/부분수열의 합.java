import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    static int N, S;
    static int result = 0;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        S = Integer.parseInt(sa[1]);

        arr = new int[N];
        sa = bf.readLine().split(" ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(sa[i]);
        }

        combination(0, 0);

        System.out.println(result);

    }

    public static void combination(int index, int sum){
        if(index == N) return;
        if(sum + arr[index] == S) result++;

        // 현재 안 뽑는 경우
        combination(index + 1, sum);
        // 현재 뽑는 경우
        combination(index + 1, sum + arr[index]);
    }
}