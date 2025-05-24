import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[] levels = new int[n];

        for (int i = 0; i < n; i++) {
            int score = Integer.parseInt(bf.readLine());
            levels[i] = score;
        }

        if (n == 1) {
            System.out.print(0);
        } else {
            int count = 0;

            for (int i = n - 2; i >= 0; i--) {
                int highLevel = levels[i + 1];
                int lowLevel = levels[i];

                if (lowLevel >= highLevel) {
                    count += lowLevel - (highLevel - 1);
                    levels[i] = highLevel - 1;
                }
            }

            System.out.print(count);
        }
    }
}
