import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N, M;
    static int[] money;

    public static void main(String[] args) throws IOException, InterruptedException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);

        money = new int[M];
        for (int i = 0; i < M; i++) {
            money[i] = Integer.parseInt(bf.readLine());
        }
        int total = 0;
        int egg = 0;

        Arrays.sort(money);

        for (int i = 0; i < M; i++) {
            int price = money[i];
            int tempEgg = 0;

            for (int j = 0; j < M; j++) {
                if (money[j] >= price) {
                    tempEgg++;
                }
                if (tempEgg == N) break;
            }

            int totalPrice = tempEgg * price;
            if (totalPrice > total) {
                total = totalPrice;
                egg = price;
            } else if (totalPrice == total) {
                egg = Math.min(egg, price);
            }
        }

        System.out.println(egg + " " + total);
    }
}
