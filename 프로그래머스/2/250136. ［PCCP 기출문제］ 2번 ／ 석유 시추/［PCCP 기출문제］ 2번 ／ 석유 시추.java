import java.util.*;

class Solution {

    static boolean[][] visited;
    // 상하좌우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    // 얻을 수 있는 석유
    static int[] oils;
    static int N, M;


    public int solution(int[][] land) {
        N = land.length;
        M = land[0].length;

        oils = new int[M + 1];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(visited[i][j] || land[i][j] == 0) continue;
                bfs(i, j, land);
            }
        }

        int result = 0;
        for(int i=0; i<oils.length; i++){
            result = Math.max(result, oils[i]);
        }

        return result;
    }

    private static void bfs(int y, int x, int[][] land){
        Set<Integer> set = new HashSet<>(); // 현재 열을 저장하기 위함
        Queue<int[]> q = new LinkedList<>();
        visited[y][x] = true;
        q.add(new int[]{y, x});
        int count = 1; // 뽑을 수 있는 석유의 최대 수
        set.add(x+1);

        while(!q.isEmpty()){
            int[] temp = q.poll();
            y = temp[0];
            x = temp[1];
            for(int i=0; i<4; i++){
                int ndy = dy[i] + y;
                int ndx = dx[i] + x;
                if(ndy < 0 || ndx < 0 || ndy >= N || ndx >= M) continue;
                if(visited[ndy][ndx] || land[ndy][ndx] == 0) continue;

                visited[ndy][ndx] = true;
                q.add(new int[]{ndy, ndx});
                set.add(ndx + 1);
                count += 1;
            }
        }

        Object[] arr = set.toArray();

        for(int i=0; i<set.size(); i++){
            Integer num = (Integer) arr[i];
            oils[num] += count;
        }
    }

}