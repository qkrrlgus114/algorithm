import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static int[][] map;
    static ArrayList<Integer> result = new ArrayList<>();
    // 전체 단지
    static int count = 0;
    // 상 우 하 좌 순서
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        map = new int[N][N];

        for(int i=0; i<N; i++){
            String s = bf.readLine();
            for(int j=0; j<N; j++){
                char c = s.charAt(j);
                map[i][j] = ((int) c) - 48;
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if (map[i][j] == 1){
                    count++;
                    bfs(i,j);
                }
            }
        }

        System.out.println(count);
        Collections.sort(result);
        for(int q : result){
            System.out.println(q);
        }

    }

    public static void bfs(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y,x});
        map[y][x] = 0;
        int homeCount = 1;

        while(q.size() != 0){
            int[] poll = q.poll();
            int ny = poll[0];
            int nx = poll[1];
            for(int i=0; i<4; i++){
                int ndx = nx + dx[i];
                int ndy = ny + dy[i];
                if (ndx >= 0 && ndy >= 0 && ndx < N && ndy < N){
                    if (map[ndy][ndx] == 1){
                        homeCount++;
                        map[ndy][ndx] = 0;
                        q.add(new int[]{ndy, ndx});
                    }
                }
            }
        }
        // 전부 끝나면 결과에 집의 수를 더해준다.
        result.add(homeCount);
    }
}