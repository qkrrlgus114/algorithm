import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());

        recur(0, true);
    }

    public static void recur(int sum, boolean target) {
        if (sum == N) {
            System.out.println(target ? "SK" : "CY");
            System.exit(0);
        }
        if (sum > N) return;

        recur(sum + 1, !target);
        recur(sum + 3, !target);
    }
}