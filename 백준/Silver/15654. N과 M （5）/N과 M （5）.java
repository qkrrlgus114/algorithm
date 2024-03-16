import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    static StringBuilder sb;
    static int N;
    static int M;
    static boolean[] visited;
    static int[] arr;
    static int[] choice;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);

        arr = new int[N];
        visited = new boolean[N];
        choice = new int[M];

        sa = bf.readLine().split(" ");

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(sa[i]);
        }
        Arrays.sort(arr);

        sb = new StringBuilder();

        dfs(0);

        System.out.println(sb);
    }

    public static void dfs(int depth){
        // 종료 조건
        if(depth == M){
            for(int i=0; i<M; i++){
                sb.append(choice[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            choice[depth] = arr[i];
            dfs(depth + 1);
            visited[i] = false;
        }
    }

}