import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);

        combination(0, 0);

        System.out.println(count);
    }

    public static void combination(int depth, int choice) {
        if (choice == M) {
            count++;
            return;
        }

        for (int i = depth; i < N; i++) {
            combination(i + 1, choice + 1);
        }
    }
}
