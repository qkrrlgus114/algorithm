import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    static int N;
    // 숫자
    static int[] arr;
    // 연산자
    static int[] cal = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String num = bf.readLine();
        N = Integer.parseInt(num);

        String[] s = bf.readLine().split(" ");

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        s = bf.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            cal[i] = Integer.parseInt(s[i]);
        }

        back(1, 0, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }

    public static void back(int cur, int depth, int sum) {
        if (depth == N - 1) {
            if (min > sum) min = sum;
            if (max < sum) max = sum;
            return;
        }

        for (int i = cur; i < N; i++) {
            for (int j = 0; j < 4; j++) {
                if (cal[j] != 0) {
                    cal[j] -= 1;
                    int calculation = calculation(j, sum, arr[i]);
                    back(i + 1, depth + 1, calculation);
                    cal[j] += 1;
                }
            }
        }
    }

    public static int calculation(int index, int sum, int now) {
        if (index == 0) {
            return sum + now;
        } else if (index == 1) {
            return sum - now;
        } else if (index == 2) {
            return sum * now;
        } else {
            return sum / now;
        }
    }

}