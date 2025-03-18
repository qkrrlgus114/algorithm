import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    static boolean[] prime = new boolean[9001];
    static List<Integer> answer = new ArrayList<>();
    static int N, M;
    static int[] cows;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        getPrime();

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);

        sa = bf.readLine().split(" ");
        cows = new int[N];
        for (int i = 0; i < N; i++) {
            cows[i] = Integer.parseInt(sa[i]);
        }

        dfs(0, 0, -1);

        Collections.sort(answer);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer.size(); i++) {
            sb.append(answer.get(i)).append(" ");
        }
        
        System.out.println(sb.length() == 0 ? -1 : sb);

    }

    // choice = 고른 소의 개수, sum = 소의 합, index = 이전에 고른 인덱스
    public static void dfs(int choice, int sum, int index) {
        if (choice == M) {
            if (prime[sum] && !answer.contains(sum)) {
                answer.add(sum);
            }
            return;
        }

        for (int i = index + 1; i < N; i++) {
            dfs(choice + 1, sum + cows[i], i);
        }
    }

    // 소수 구하기
    public static void getPrime() {
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        for (int i = 2; i <= 9000; i++) {
            for (int j = i + i; j <= 9000; j += i) {
                prime[j] = false;
            }
        }
    }

}
