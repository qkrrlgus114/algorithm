import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int idx = 1;

        while (true) {
            int n = Integer.parseInt(bf.readLine());
            if (n == 0) {
                break;
            }
            if (idx != 1) {
                sb.append("\n");
            }

            sb.append("Group ").append(idx++).append("\n");

            String[] names = new String[n];
            String[][] messages = new String[n][n - 1];

            // 입력
            for (int i = 0; i < n; i++) {
                String[] sa = bf.readLine().split(" ");
                names[i] = sa[0];
                for (int j = 0; j < n - 1; j++) {
                    messages[i][j] = sa[j + 1];
                }
            }

            // N이 있는지 여부
            boolean statusN = false;

            // 메시지 배열 순회
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (messages[i][j].equals("N")) {
                        statusN = true;
                        int a = n - j - 1;
                        int b = i + a;
                        if (b >= n) {
                            b %= n;
                        }
                        addName(names[b], names[i]);
                    }
                }
            }

            if (!statusN) {
                sb.append("Nobody was nasty").append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void addName(String target, String base) {
        sb.append(target).append(" was nasty about ").append(base).append("\n");
    }
}