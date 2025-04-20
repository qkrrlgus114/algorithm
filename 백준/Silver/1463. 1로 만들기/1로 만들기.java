import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int X;
    static int[] memo;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        X = Integer.parseInt(bf.readLine());
        memo = new int[X + 1];

        int answer = recur(X);

        System.out.println(answer);
    }

    public static int recur(int num) {
        if (num == 1) {
            return 0;
        }

        if (memo[num] != 0) return memo[num];

        int min = Integer.MAX_VALUE;

        if (num % 3 == 0) min = Math.min(min, recur(num / 3) + 1);
        if (num % 2 == 0) min = Math.min(min, recur(num / 2) + 1);
        min = Math.min(min, recur(num - 1) + 1);

        return memo[num] = min;
    }


}