import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean[] check; // 배열 사용 여부
    static boolean[] choice = new boolean[13]; // 숫자 사용 여부
    static int N, X, Y;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");

        N = Integer.parseInt(sa[0]);
        X = Integer.parseInt(sa[1]) - 1;
        Y = Integer.parseInt(sa[2]) - 1;
        check = new boolean[2 * N];

        // Y랑 X는 고정으로 정해줌
        choice[Y - X - 1] = true;
        check[Y] = true;
        check[X] = true;

        dfs(N);

        System.out.println(answer);

    }

    public static void dfs(int depth) {
        if (depth == 0) {
            answer++;
            return;
        }

        if (choice[depth]) {
            dfs(depth - 1);
        } else {
            for (int j = 0; j < check.length; j++) {
                if (j + depth + 1 >= 2 * N) break;
                // j, j + depth + 1이 전부 사용됐는지 확인(두 숫자 사이에는 (j + depth + 1) - (j) = depth를 만족해야 함)
                if (check[j] || check[j + depth + 1]) continue;

                check[j] = true;
                check[j + depth + 1] = true;
                choice[depth] = true;

                dfs(depth - 1);

                check[j] = false;
                check[j + depth + 1] = false;
                choice[depth] = false;
            }
        }

    }

}
