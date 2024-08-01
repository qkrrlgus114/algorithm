import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static boolean[] visited;
    static int[] kits;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        K = Integer.parseInt(sa[1]);

        sa = bf.readLine().split(" ");
        visited = new boolean[N];
        kits = new int[N];

        for(int i=0; i<N; i++){
            kits[i] = Integer.parseInt(sa[i]);
        }

        dfs(0, 500);

        System.out.println(answer);
    }

    public static void dfs(int day, int weight){
        if(weight < 500) return;
        if(day == N){
            answer++;
            return;
        }

        for(int i=0; i<N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            dfs(day + 1, weight - K + kits[i]);
            visited[i] = false;
        }
    }
}
