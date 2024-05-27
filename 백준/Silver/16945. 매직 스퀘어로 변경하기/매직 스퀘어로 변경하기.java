import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] arr = new int[3][3];
    static boolean[] check = new boolean[10];
    static boolean[][] visited = new boolean[3][3];
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            String[] sa = bf.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(sa[j]);
            }
        }

        dfs(0, 0);

        System.out.println(answer);


    }

    private static void dfs(int depth, int sum) {
        // 종료 조건
        if (depth == 9) {
            if (!numberCheck()) return;
            if (!magic()) return;

            answer = Math.min(answer, sum);
            return;
        }

        // 재귀 조건
        int i = depth / 3;
        int j = depth % 3;

        for (int l = 1; l <= 9; l++) {
            if (check[l]) continue;
            int temp = arr[i][j];
            check[l] = true;
            arr[i][j] = l;
            dfs(depth + 1, sum + Math.abs(temp - l));
            check[l] = false;
            arr[i][j] = temp;
        }

    }

    private static boolean magic() {
        int temp = arr[0][0] + arr[0][1] + arr[0][2];
        if (arr[1][0] + arr[1][1] + arr[1][2] == temp &&
                arr[2][0] + arr[2][1] + arr[2][2] == temp &&
                arr[0][0] + arr[1][0] + arr[2][0] == temp &&
                arr[0][1] + arr[1][1] + arr[2][1] == temp &&
                arr[0][2] + arr[1][2] + arr[2][2] == temp &&
                arr[0][0] + arr[1][1] + arr[2][2] == temp &&
                arr[0][2] + arr[1][1] + arr[2][0] == temp)
            return true;
        return false;
    }

    private static boolean numberCheck() {
        for (int i = 1; i <= 9; i++) {
            if (!check[i]) return false;
        }
        return true;
    }

}


