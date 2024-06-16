import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Hashtable;

public class Main {

    // 그라운드 선수
    static int[] ground = new int[3];
    // 최고 점수
    static int maxPoint = Integer.MIN_VALUE;

    static int[] playerSequence = new int[10];
    static boolean[] visited = new boolean[10];
    // 이닝 수
    static int N;
    // 얻는 결과
    static int[][] baseballResults;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        playerSequence[4] = 1;
        visited[1] = true;

        baseballResults = new int[N][10];

        for (int i = 0; i < N; i++) {
            String[] sa = bf.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                baseballResults[i][j + 1] = Integer.parseInt(sa[j]);
            }
        }

        setSequence(1);

        System.out.println(maxPoint);
    }

    // 타순 정하기(타자 순서)
    private static void setSequence(int count) {
        // 종료 조건
        if (count == 10) {
            // 야구게임 시작
            playBaseball();
            return;
        }

        for (int i = 1; i < 10; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            playerSequence[count] = i;
            if (count == 3) {
                setSequence(count + 2);
            } else {
                setSequence(count + 1);
            }
            visited[i] = false;
            playerSequence[count] = 0;
        }
    }

    // 야구게임
    private static void playBaseball() {
        int point = 0;
        int sequence = 1;

        for (int i = 0; i < N; i++) {
            int outCount = 0;
            Arrays.fill(ground, 0);

            while (outCount != 3) {
                int player = playerSequence[sequence];

                // 현재 타자의 결과
                int skill = baseballResults[i][player];

                if (skill == 0) {
                    outCount++;
                } else {
                    point += runPlayer(skill);
                }

                sequence = (sequence % 9) + 1;
            }
        }

        maxPoint = Math.max(maxPoint, point);
    }

    // 주루
    private static int runPlayer(int run) {
        int point = 0;

        for (int i = 2; i >= 0; i--) {
            if (ground[i] == 1) {
                if (i + run >= 3) {
                    point++;
                }else{
                    ground[i + run] = 1;
                }
                ground[i] = 0;
            }
        }
        if (run != 4) {
            ground[run - 1] = 1;
        } else {
            point++;
        }

        return point;
    }
}

