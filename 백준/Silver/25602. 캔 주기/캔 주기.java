import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] can;
    static int[][] rang;
    static int[][] mary;
    static int N, K;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        K = Integer.parseInt(sa[1]);
        can = new int[N];
        rang = new int[K][N];
        mary = new int[K][N];

        // 캔의 개수
        sa = bf.readLine().split(" ");
        for(int i=0; i<N; i++){
            can[i] = Integer.parseInt(sa[i]);
        }

        // 랑이
        for(int i=0; i<K; i++){
            sa = bf.readLine().split(" ");
            for(int j=0; j<N; j++){
                rang[i][j] = Integer.parseInt(sa[j]);
            }
        }

        // 메리
        for(int i=0; i<K; i++){
            sa = bf.readLine().split(" ");
            for(int j=0; j<N; j++){
                mary[i][j] = Integer.parseInt(sa[j]);
            }
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    private static void dfs(int depth, int sum){
        // 종료 조건
        if(depth == K){
            answer = Math.max(answer, sum);
            return;
        }

        // 재귀 조건
        for(int i=0; i<N; i++){
            if(can[i] > 0){
                can[i]--;
                for(int j=0; j<N; j++){
                    if(can[j] > 0){
                        can[j]--;
                        dfs(depth + 1, sum + rang[depth][i] + mary[depth][j]);
                        can[j]++;
                    }
                }
                can[i]++;
            }
        }
    }
}

