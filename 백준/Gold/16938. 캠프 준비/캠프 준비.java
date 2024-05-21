import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    static int N, L, R, X;
    static int[] arr;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        L = Integer.parseInt(sa[1]);
        R = Integer.parseInt(sa[2]);
        X = Integer.parseInt(sa[3]);

        arr = new int[N];
        sa = bf.readLine().split(" ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(sa[i]);
        }

        dfs(0, 0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);

        System.out.println(answer);
    }

    public static void dfs(int depth, int sum, int count, int min, int max){
        // 종료 조건
        if(count >= 2){
            if((sum >= L && sum <= R) && (Math.abs(max - min) >= X)){
                answer++;
            }
        }

        // 재귀 조건
        for(int i=depth; i<N; i++){
            dfs(i+1, sum + arr[i], count + 1, Math.min(min, arr[i]), Math.max(max, arr[i]));
        }
    }
}

