import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int K = Integer.parseInt(sa[1]);
        int C = Integer.parseInt(sa[2]);

        boolean[] check = new boolean[N];
        int[] product = new int[N];
        sa = bf.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            product[i] = Integer.parseInt(sa[i]);
        }
        Arrays.sort(product);

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= C; i++) {
            int x = i;
            int cnt = N; // 남은 상품의 개수
            for (int j = 0; j < N; j++) {
                if (x - product[j] >= 0) {
                    if (cnt == K) break;
                    check[j] = true; // 못훔쳐감. 상훈이가 챙김
                    x -= product[j];
                    cnt--;
                }
            }

            int value = 0;
            int k = 0;
            for (int j = 0; j < N; j++) {
                if (!check[j] && K > k) {
                    value += product[j];
                    k++;
                }
            }

            sb.append(value).append("\n");
        }

        if (N < K) {
            int value = 0;
            value += Arrays.stream(product).sum();
            System.out.println(value);
        } else {
            System.out.println(sb);
        }
    }
}