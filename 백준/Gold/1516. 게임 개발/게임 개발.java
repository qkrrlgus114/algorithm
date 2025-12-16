import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        List<Integer>[] list = new List[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        // 시간 배열
        int[] times = new int[N + 1];
        int[] result = new int[N + 1];

        for (int i = 0; i < N; i++) {
            String[] sa = bf.readLine().split(" ");
            for (int j = 0; j < sa.length; j++) {
                int value = Integer.parseInt(sa[j]);
                if (value == -1) {
                    continue;
                }

                // 걸리는 시간을 의미
                if (j == 0) {
                    times[i + 1] = value;
                } else {
                    list[i + 1].add(value);
                }
            }
        }

        int cnt = 0;
        while (cnt != N) {
            for (int i = 1; i <= N; i++) {
                if (result[i] != 0) {
                    continue;
                }

                boolean ready = true;
                int time = 0;
                for (int j = 0; j < list[i].size(); j++) {
                    int prepare = list[i].get(j);
                    time = Math.max(time, result[prepare]);

                    if (result[prepare] == 0) {
                        ready = false;
                        break;
                    }
                }

                // 준비가 됐으면 시간을 넣어준다.
                if (ready) {
                    result[i] = times[i] + time;
                    cnt++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);
    }
}
