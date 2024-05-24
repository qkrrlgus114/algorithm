import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static boolean[][] domino = new boolean[7][7];
    static int[][] arr = new int[8][7];
    static boolean[][] visited = new boolean[8][7];
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 8; i++) {
            char[] charArray = bf.readLine().toCharArray();
            for (int j = 0; j < 7; j++) {
                arr[i][j] = charArray[j] - 48;
            }
        }

        dfs(0, 0);
        System.out.println(answer);

    }

    private static void dfs(int y, int x) {
        // 종료
        if (y >= 8) {
            boolean check = true;
            outer:
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 7; j++) {
                    if (!visited[i][j]) {
                        check = false;
                        break outer;
                    }
                }
            }
            if (check) answer++;
            return;
        }

        // 다음 칸으로 이동
        if (visited[y][x]) {
            if (x + 1 < 7) dfs(y, x + 1);
            else dfs(y + 1, 0);
            return;
        }

        // 가로 확인
        if (x + 1 < 7 && !visited[y][x + 1]) {
            int a = arr[y][x];
            int b = arr[y][x+1];
            if(!domino[a][b] && !domino[b][a]){
                visited[y][x] = true;
                visited[y][x + 1] = true;
                domino[a][b] = true;
                domino[b][a] = true;
                if (x + 2 < 7) dfs(y, x + 2);
                else dfs(y + 1, 0);
                visited[y][x] = false;
                visited[y][x + 1] = false;
                domino[a][b] = false;
                domino[b][a] = false;
            }
        }

        // 세로 확인
        if (y + 1 < 8 && !visited[y + 1][x]) {
            int a = arr[y][x];
            int b = arr[y+1][x];
            if(!domino[a][b] && !domino[b][a]){
                visited[y][x] = true;
                visited[y + 1][x] = true;
                domino[a][b] = true;
                domino[b][a] = true;
                if (x + 1 < 7) dfs(y, x + 1);
                else dfs(y + 1, 0);
                visited[y][x] = false;
                visited[y + 1][x] = false;
                domino[a][b] = false;
                domino[b][a] = false;
            }
        }
    }


}


