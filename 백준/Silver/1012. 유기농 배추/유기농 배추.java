import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] arr;
    // 상 우 하 좌
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int W;
    static int H;
    static int result;



    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        // 테스트 케이스 개수
        for(int k=0; k<T; k++){
            result = 0;
            String[] str = bf.readLine().split(" ");

            W = Integer.parseInt(str[0]); // 가로
            H = Integer.parseInt(str[1]); // 세로
            int count = Integer.parseInt(str[2]); // 배추 개수

            arr = new int[H][W];

            for(int i=0; i<count; i++){
                String[] temp = bf.readLine().split(" ");

                arr[Integer.parseInt(temp[1])][Integer.parseInt(temp[0])] = 1;
            }

            for(int i=0; i<H; i++){
                for(int j=0; j<W; j++){
                    if(arr[i][j] == 1){
                        bfs(i, j);
                        result ++;
                    }
                }
            }
            System.out.println(result);
        }
    }

    public static void bfs(int y, int x){
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{y,x});
        arr[y][x] = 0;
        while(q.size() != 0){
            int[] temp = q.poll();
            int ny = temp[0];
            int nx = temp[1];

            for(int i=0; i<4; i++){
                int ndy = ny + dy[i];
                int ndx = nx + dx[i];
                if(ndy >= 0 && ndy < H && ndx >= 0 && ndx < W){
                    if(arr[ndy][ndx] == 1){
                        arr[ndy][ndx] = 0;
                        q.add(new int[]{ndy, ndx});
                    }
                }
            }
        }
    }
}
