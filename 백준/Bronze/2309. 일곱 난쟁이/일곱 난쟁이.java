import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] nan = new int[9];
        int sum = 0; // 난쟁이 키의 합
        for (int i = 0; i < 9; i++) {
            nan[i] = Integer.parseInt(bf.readLine());
            sum += nan[i];
        }
        Arrays.sort(nan);

        StringBuilder sb = new StringBuilder();

        // 난쟁이 총 합에서 2명을 뺀 것이 100이 되면 정답
        outer:
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (sum - nan[i] - nan[j] == 100) {
                    for (int k = 0; k < 9; k++) {
                        if (k != i && k != j) sb.append(nan[k]).append("\n");
                    }
                    break outer;
                }
            }
        }

        System.out.println(sb);

    }
}
