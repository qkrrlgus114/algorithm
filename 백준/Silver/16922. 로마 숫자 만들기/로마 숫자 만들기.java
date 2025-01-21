import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static int N;
    static Set<Integer> set = new HashSet<>();
    static int[] arr = {1, 5, 10, 50};


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());

        dfs(0, 0, 0);

        System.out.println(set.size());

    }

    private static void dfs(int choice, int depth, int sum) {
        if (choice == N) {
            set.add(sum);
            return;
        }

        for (int i = depth; i < arr.length; i++) {
            dfs(choice + 1, i, sum + arr[i]);
        }
    }


}