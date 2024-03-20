import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    static int[] num;
    static int N, d;
    static boolean[] visited;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        d = Integer.parseInt(sa[1]);
        num = new int[d];
        visited = new boolean[d];

        permutation(0);
        if(ans == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);

    }

    public static void permutation(int depth){
        // 종료
        if(depth == d){
            // 진법변환 시작
            int result = 0;
            for(int i=0; i<d; i++){
                result += num[d-1-i] * Math.pow(d, i);
            }
            if(result > N){
                ans = Math.min(ans, result);
            }
            return;
        }

        int start = 0;
        if(depth == 0) start = 1;
        // 재귀
        for(int i=start; i<d; i++){
            if(visited[i]) continue;
            visited[i] = true;
            num[depth] = i;
            permutation(depth + 1);
            visited[i] = false;
        }
    }
}

