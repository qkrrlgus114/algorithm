import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int N;
    static int M;
    static int[][] map;
    // 상 우 하 좌
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    // 현재 안전 영역의 개수
    static int zero_count = 0;
    static int[][] copy_map;
    static int[][] virus;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);

        map = new int[N][M];
        copy_map = new int[N][M];
        virus = new int[10][2];
        int virus_index = 0;
        int virus_count = 0;

        for (int i = 0; i < N; i++) {
            sa = bf.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(sa[j]);
                if (map[i][j] == 1) zero_count++;
                else if (map[i][j] == 2) {
                    virus_count++;
                }
            }
        }
        virus = new int[virus_count][2];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    virus[virus_index][0] = i;
                    virus[virus_index][1] = j;
                    virus_index++;
                }
            }
        }

        back(0, 0, 0);
        System.out.println(max);
    }

    public static void back(int y, int x, int wall) {
        // 만약에 벽을 다 사용했다면 bfs
        if (wall == 3) {
//            for(int i=0; i<N; i++){
//                for(int j=0; j<M; j++){
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println("다음칸");
            // 원본 맵을 저장
            copy_map = copy(copy_map, map);
            // bfs 로직
            bfs();
            // 안전영역 확인
            int safe_zone = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(map[i][j] == 0) safe_zone++;
                }
            }
            if(safe_zone > max) {
                max = safe_zone;
            }
            map = copy(map, copy_map);
            return;
        }

        for (int i = y; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 현재 위치가 0이면 다음 백트래킹 조건에 따라 실행
                if (map[i][j] == 0) {
                    // 벽 세우기
                    map[i][j] = 1;
                    if (j == M - 1 && i < N - 1) {
                        back(i + 1, 0, wall + 1);
                    } else if (j < M - 1) {
                        back(i, j + 1, wall + 1);
                    } else {
                        back(i, j, wall + 1);
                    }
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void bfs() {
        for (int i = 0; i < virus.length; i++) {
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{virus[i][0], virus[i][1]});

            while (!q.isEmpty()) {
                int[] temp = q.poll();
                int y = temp[0];
                int x = temp[1];
                for (int d = 0; d < 4; d++) {
                    int ndy = y + dy[d];
                    int ndx = x + dx[d];
                    // 맵 범위 안에 있는지 확인
                    if (ndy < N && ndx < M && ndy >= 0 && ndx >= 0) {
                        if (map[ndy][ndx] == 0) {
                            map[ndy][ndx] = 2;
                            q.add(new int[]{ndy, ndx});
                        }
                    }
                }
            }
        }

    }

    public static int[][] copy(int[][] copy, int[][] origin) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[i][j] = origin[i][j];
            }
        }
        return copy;
    }


}