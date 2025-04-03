import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int N, M;
    static int[] answerArr;
    static List<int[]> models = new ArrayList<>();
    static boolean[] visited;
    static double maxValue = 0;
    static int modelCnt = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);

        sa = bf.readLine().split(" ");
        answerArr = new int[M];
        visited = new boolean[N];
        for (int i = 0; i < M; i++) {
            answerArr[i] = Integer.parseInt(sa[i]);
        }

        for (int i = 0; i < N; i++) {
            sa = bf.readLine().split(" ");
            int[] arr = new int[M];
            for (int j = 0; j < M; j++) {
                arr[j] = Integer.parseInt(sa[j]);
            }
            models.add(arr);
        }

        dfs(0, 0);

        System.out.println(modelCnt == 1 ? 0 : 1);


    }

    // depth - 고른 개수, index - 고른 위치
    public static void dfs(int depth, int index) {
        // 홀수면 판단을 진행한다.
        if (depth % 2 != 0) {
            double result = modelCheck();
            if (maxValue < result) {
                maxValue = result;
                modelCnt = depth;
            } else if (maxValue == result) {
                if (depth == 1) modelCnt = 1;
            }
        }

        for (int i = index; i < N; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            dfs(depth + 1, i + 1);
            visited[i] = false;
        }
    }

    public static double modelCheck() {
        int totalCnt = M;
        int matchCnt = 0; // 맞춘 개수

        int[] arr = new int[M];
        for (int i = 0; i < M; i++) {
            int zero = 0;
            int one = 0;
            for (int j = 0; j < N; j++) {
                if (!visited[j]) continue;

                if (models.get(j)[i] == 0) zero++;
                else one++;
            }

            if (zero > one) arr[i] = 0;
            else arr[i] = 1;
        }

        for (int i = 0; i < M; i++) {
            if (answerArr[i] == arr[i]) matchCnt++;
        }

        return (double) matchCnt / totalCnt;
    }

}
