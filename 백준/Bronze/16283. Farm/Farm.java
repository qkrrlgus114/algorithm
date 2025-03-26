import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int a = Integer.parseInt(sa[0]); // 양 사료
        int b = Integer.parseInt(sa[1]); // 염소 사료
        int n = Integer.parseInt(sa[2]); // 양 + 염소 수
        int w = Integer.parseInt(sa[3]); // 전체 소비 사료

        StringBuilder sb = new StringBuilder();

        // 양
        outer:
        for (int i = 1; i <= n; i++) {
            // 염소
            for (int j = 1; j <= n; j++) {
                if (i + j > n) break;
                // 양사료 + 염소사료 / 양 + 염소
                if ((i * a) + (j * b) == w && i + j == n) {
                    if (sb.length() != 0) {
                        sb.setLength(0);
                        break outer;
                    }
                    sb.append(i).append(" ").append(j);
                }
            }
        }

        System.out.println(sb.length() == 0 ? -1 : sb);
    }
}
