import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;


public class Main {

    static boolean[][] visited;
    static int N;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String n = bf.readLine();
        N = Integer.parseInt(n);
        visited = new boolean[N][N];

        back(0);

        System.out.println(count);

    }

    public static void back(int queen) {
        if (queen == N) {
            count++;
            return;
        }

        for (int j = 0; j < N; j++) {
            if (check(queen, j)) {
                visited[queen][j] = true;
                back(queen + 1);
                visited[queen][j] = false;
            }
        }
    }

    public static boolean check(int y, int x) {
        for (int i = 0; i < y; i++) {
            // 위
            if(visited[i][x]){
                return false;
            }

            // 왼쪽 대각선
            int temp = x - (y - i);
            if(temp >= 0 && visited[i][temp]){
                return false;
            }

            // 오른쪽 대각선
            temp = x + (y - i);
            if(temp < N && visited[i][temp]){
                return false;
            }
        }
        return true;
    }
}
