import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    // 상 하 좌 우(U, D, L ,R)
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static char[][] graph;
    static int N;
    static int cur_y = 0;
    static int cur_x = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        N = Integer.parseInt(s);
        graph = new char[N][N];
        // 초기화
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                graph[i][j] = '.';
            }
        }

        // 명령
        s = bf.readLine();

        for(int z=0; z<s.length(); z++){
            char temp = s.charAt(z);
            if(temp == 'U') move(0);
            else if(temp == 'D') move(1);
            else if(temp == 'L') move(2);
            else if(temp == 'R') move(3);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                sb.append(graph[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    // 팔 이동
    public static void move(int dir){
        int ndy = cur_y + dy[dir];
        int ndx = cur_x + dx[dir];
        if(ndy < 0 || ndx < 0 || ndy >= N || ndx >= N) return;

        // 이전 위치와 이동 위치에 똑같은 dir로 그음
        // 위 아래인 경우
        if(dir == 0 || dir == 1){
            if(graph[cur_y][cur_x] == '-') {
                graph[cur_y][cur_x] = '+';
            }else if(graph[cur_y][cur_x] == '.'){
                graph[cur_y][cur_x] = '|';
            }
            if(graph[ndy][ndx] == '.'){
                graph[ndy][ndx] = '|';
            }else if(graph[ndy][ndx] == '-'){
                graph[ndy][ndx] = '+';
            }
        }
        // 왼쪽 오른쪽인 경우
        else{
            if(graph[cur_y][cur_x] == '|') {
                graph[cur_y][cur_x] = '+';
            }else if(graph[cur_y][cur_x] == '.'){
                graph[cur_y][cur_x] = '-';
            }
            if(graph[ndy][ndx] == '.'){
                graph[ndy][ndx] = '-';
            }else if(graph[ndy][ndx] == '|'){
                graph[ndy][ndx] = '+';
            }
        }
        cur_y = ndy;
        cur_x = ndx;
    }
}
