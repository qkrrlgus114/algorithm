import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, answer;
    static int[] arr;
    static int[] choice;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        arr = new int[N];
        choice = new int[N];
        visited = new boolean[N];

        String[] sa = bf.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(sa[i]);
        }

        combination(0);

        System.out.println(answer);

    }

    public static void combination(int depth) {
        if (depth == N) {
            int sum = 0;
            for (int i = 1; i < N; i++) {
                sum += Math.abs(choice[i - 1] - choice[i]);
            }
            answer = Math.max(sum, answer);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            choice[depth] = arr[i];
            combination(depth + 1);
            visited[i] = false;
        }


    }


}

