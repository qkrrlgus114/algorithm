import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] visited;
    static int[] choice;
    static int result =Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        N = Integer.parseInt(s);

        String[] sa = bf.readLine().split(" ");
        arr = new int[N];
        visited = new boolean[N];
        choice = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(sa[i]);
        }

        dfs(0);
        System.out.println(result);


    }

    public static void dfs(int depth){
        if(depth == N){
            int sum = 0;
            for(int i=0; i<N-1; i++){
                sum += Math.abs(choice[i] - choice[i+1]);
            }
            result = Math.max(result, sum);
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



