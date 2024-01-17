import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static int M;
    static char[][] map;
    static boolean[][][][][][][][] visited;
    // 상 우 하 좌
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);
        map = new char[N][M];

        visited = new boolean[N][M][2][2][2][2][2][2];
        for(int i=0; i<N; i++){
            char[] c = bf.readLine().toCharArray();
            for(int j=0; j<M; j++){
                map[i][j] = c[j];
            }
        }

        int result = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == '0') {
                    result = bfs(i, j);
                    break;
                }
            }
        }

        System.out.println(result);
    }

    public static int bfs(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        // y, x, 이동횟수, a, b, c, d, e, f
        q.add(new int[]{y, x, 0, 0, 0, 0, 0, 0, 0});
        visited[y][x][0][0][0][0][0][0] = true;
        map[y][x] = '.';

        while(!q.isEmpty()){
            int[] temp = q.poll();
            y = temp[0];
            x = temp[1];
            int n_count = temp[2];
            int a = temp[3];
            int b = temp[4];
            int c = temp[5];
            int d = temp[6];
            int e = temp[7];
            int f = temp[8];


            for(int i=0; i<4; i++){
                int ndy = y + dy[i];
                int ndx = x + dx[i];
                // 범위 체크
                if(ndy >= 0 && ndx >= 0 && ndy < N && ndx < M){
                    // 방문 체크를 진행해야하는데 열쇠를 가지고 있는 여부를 어떻게 알지?
                    if(!visited[ndy][ndx][a][b][c][d][e][f]){
                        // 현재 위치가 열쇠면
                        if(map[ndy][ndx] == 'a' || map[ndy][ndx] == 'b' || map[ndy][ndx] == 'c' ||
                                map[ndy][ndx] == 'd' || map[ndy][ndx] == 'e' || map[ndy][ndx] == 'f'){
                            char key = map[ndy][ndx];
                            int na = a;
                            int nb = b;
                            int nc = c;
                            int nd = d;
                            int ne = e;
                            int nf = f;
                            if(key == 'a') {
                                na = 1;
                            }
                            else if(key == 'b'){
                                nb =1;
                            }
                            else if(key == 'c'){
                                nc =1;
                            }
                            else if(key == 'd') nd =1;
                            else if(key == 'e') ne =1;
                            else if(key == 'f') nf =1;
                            visited[ndy][ndx][na][nb][nc][nd][ne][nf] = true;
                            q.add(new int[]{ndy, ndx, n_count + 1, na, nb, nc, nd, ne, nf});
                        }
                        // 현재 위치가 문이면
                        else if(map[ndy][ndx] == 'A' || map[ndy][ndx] == 'B' || map[ndy][ndx] == 'C' ||
                                map[ndy][ndx] == 'D' || map[ndy][ndx] == 'E' || map[ndy][ndx] == 'F'){
                            char door = map[ndy][ndx];
                            if(door == 'A'){
                                if(a == 1){
                                    visited[ndy][ndx][a][b][c][d][e][f] = true;
                                    q.add(new int[]{ndy, ndx, n_count + 1, a, b, c, d, e, f});
                                }
                            }else if(door == 'B'){
                                if(b == 1){
                                    visited[ndy][ndx][a][b][c][d][e][f] = true;
                                    q.add(new int[]{ndy, ndx, n_count + 1, a, b, c, d, e, f});
                                }
                            }else if(door == 'C'){
                                if(c == 1){
                                    visited[ndy][ndx][a][b][c][d][e][f] = true;
                                    q.add(new int[]{ndy, ndx, n_count + 1, a, b, c, d, e, f});
                                }
                            }else if(door == 'D'){
                                if(d == 1){
                                    visited[ndy][ndx][a][b][c][d][e][f] = true;
                                    q.add(new int[]{ndy, ndx, n_count + 1, a, b, c, d, e, f});
                                }
                            }else if(door == 'E'){
                                if(e == 1){
                                    visited[ndy][ndx][a][b][c][d][e][f] = true;
                                    q.add(new int[]{ndy, ndx, n_count + 1, a, b, c, d, e, f});
                                }
                            }else if(door == 'F'){
                                if(f == 1){
                                    visited[ndy][ndx][a][b][c][d][e][f] = true;
                                    q.add(new int[]{ndy, ndx, n_count + 1, a, b, c, d, e, f});
                                }
                            }
                        }
                        // 길이면
                        else if(map[ndy][ndx] == '.'){
                            visited[ndy][ndx][a][b][c][d][e][f] = true;
                            q.add(new int[]{ndy, ndx, n_count + 1, a, b, c, d, e, f});
                        }else if(map[ndy][ndx] == '1'){
                            return n_count + 1;
                        }
                    }
                }
            }
        }
        return -1;
    }
}