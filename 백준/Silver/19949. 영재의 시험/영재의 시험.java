import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] correct = new int[10];
    static int[] choice = new int[10];
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        for (int i = 0; i < 10; i++) {
            correct[i] = Integer.parseInt(sa[i]);
        }

        dfs(0, 0, 0);

        System.out.println(answer);

    }

    public static void dfs(int curIdx, int preIdx, int channingCnt) {
        if (curIdx >= 10) {
            int point = 0;
            for (int i = 0; i < 10; i++) {
                if (correct[i] != choice[i]) continue;
                point++;
            }
            if (point >= 5) answer++;

            return;
        }

        for (int i = 0; i < 5; i++) {
            if (preIdx == i && channingCnt >= 2) {
                continue;
            } else if (preIdx == i && channingCnt < 2) {
                choice[curIdx] = i + 1;
                dfs(curIdx + 1, i, channingCnt + 1);
            } else {
                choice[curIdx] = i + 1;
                dfs(curIdx + 1, i, 1);
            }
        }
    }
}