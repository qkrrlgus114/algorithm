import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int highNumber = 0;
    static int answer = 0;
    static int N;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        visited = new boolean[5];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int[] cards = new int[5];
            for (int j = 0; j < 5; j++) {
                cards[j] = Integer.parseInt(st.nextToken());
            }

            dfs(0, cards, 0, 0, i + 1);
        }

        System.out.println(answer);
    }

    // 몇 개 골랐는지, 카드 배열, 숫자의 총 합, 시작 카드 인덱스, 현재 사람 번호
    private static void dfs(int choice, int[] cards, int sum, int depth, int num) {
        // 3개를 다 골랐는지 판단
        if (choice == 3) {
            if (sum >= 10) {
                if (sum % 10 >= highNumber) {
                    highNumber = sum % 10;
                    answer = Math.max(answer, num);
                }
            } else {
                if (sum >= highNumber) {
                    highNumber = sum;
                    answer = Math.max(answer, num);
                }
            }
            return;
        }

        for (int i = depth; i < cards.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(choice + 1, cards, sum + cards[i], i + 1, num);
            visited[i] = false;
        }


    }


}