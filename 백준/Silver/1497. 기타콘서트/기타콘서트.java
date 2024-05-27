import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    // 기타의 개수
    static int answer = Integer.MAX_VALUE;
    // 연주 곡의 개수
    static int playMusic = 0;
    // 기타의 이름
    static String[] guitars;
    static Map<String, boolean[]> map = new HashMap<>();
    // 기타 선택 여부
    static boolean[] visited;
    // 음악 선택 여부
    static boolean[] musicChoice;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);
        visited = new boolean[N];
        musicChoice = new boolean[M];

        guitars = new String[N];
        for (int i = 0; i < N; i++) {
            sa = bf.readLine().split(" ");
            guitars[i] = sa[0];
            boolean[] check = new boolean[M];
            char[] temp = sa[1].toCharArray();
            for (int j = 0; j < M; j++) {
                if (temp[j] == 'Y') check[j] = true;
                else check[j] = false;
                map.put(guitars[i], check);
            }
        }

        dfs(0);
        System.out.println(answer == 0 ? -1 : answer);
    }

    private static void dfs(int depth) {
        // 종료 조건
        if (depth == N) {
            int count = 0;
            // 연주 곡의 개수 확인
            for (int i = 0; i < musicChoice.length; i++) {
                if (musicChoice[i]) count++;
            }

            if (playMusic <= count) {
                playMusic = count;

                count = 0;
                for (int j = 0; j < visited.length; j++) {
                    if (visited[j]) count++;
                }
                answer = Math.min(answer, count);
            }
            return;
        }

        // 재귀 조건
        for (int i = depth; i < guitars.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            boolean[] musics = map.get(guitars[i]);
            boolean[] curMusicChoice;
            curMusicChoice = copy(musicChoice);
            for (int j = 0; j < musics.length; j++) {
                if (musics[j]) musicChoice[j] = true;
            }
            // 고른 경우
            dfs(i + 1);
            musicChoice = copy(curMusicChoice);
            visited[i] = false;

            // 안 고른 경우
            dfs(i + 1);
        }
    }

    private static boolean[] copy(boolean[] ori) {
        boolean[] copy = new boolean[ori.length];
        for (int i = 0; i < ori.length; i++) {
            copy[i] = ori[i];
        }

        return copy;
    }

}


