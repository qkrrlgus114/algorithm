import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    /**
     *
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(sa[i]);
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < 5; i++) {
            int value = arr[i];
            while (true) {
                int sum = 0;
                if (value % arr[0] == 0) sum++;
                if (value % arr[1] == 0) sum++;
                if (value % arr[2] == 0) sum++;
                if (value % arr[3] == 0) sum++;
                if (value % arr[4] == 0) sum++;
                if (sum >= 3) {
                    answer = Math.min(answer, value);
                    break;
                }
                value += arr[i];
            }
        }

        System.out.println(answer);
    }
}
