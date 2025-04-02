import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /**
     * 1. S의 문자열로 점수 문자열을 먼저 구한다.
     * 2. 1에서 구한 점수 문자열과 같은 S 문자열을 사전순으로 구하고싶다.
     * <p>
     * 즉 A ~ I까지 모든 조합으로 점수 문자열을 구해야 하나?
     * <p>
     * 하나 체크할 때마다 행, 열을 확인한다.
     */

    static char[][] board = new char[3][3];
    static boolean[] alpha = new boolean[27];
    static List<String> answerList = new ArrayList<>();
    static String pointStr;
    static String seedStr;
    static Map<Character, int[]> nodeList;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // 정답 출력용
        StringBuilder sb = new StringBuilder();


        int T = Integer.parseInt(bf.readLine());
        for (int t = 0; t < T; t++) {
            nodeList = new HashMap<>();
            boolean[][] visited = new boolean[3][3];
            pointStr = "";
            seedStr = bf.readLine();
            for (int i = 0; i < 3; i++) {
                char[] array = bf.readLine().toCharArray();
                for (int j = 0; j < 3; j++) {
                    board[i][j] = array[j];
                    nodeList.put(board[i][j], new int[]{i, j});
                }
            }

            // 먼저 시드 문자열의 점수 문자열을 구한다.
            getPointStr(0, new StringBuilder(), visited);

            combination(0, new StringBuilder(), new StringBuilder(), visited);
            Collections.sort(answerList);

            sb.append(pointStr).append(" ").append(answerList.get(0)).append("\n");
            answerList = new ArrayList<>();
            alpha = new boolean[27];
        }
        System.out.println(sb);
    }

    // 시드 문자열의 점수 문자열 구하기
    public static void getPointStr(int depth, StringBuilder sb, boolean[][] visited) {
        if (depth == 9) {
            pointStr = sb.toString();
            return;
        }

        int[] arr = nodeList.get(seedStr.charAt(depth));
        visited[arr[0]][arr[1]] = true;
        String point = checkPoint(arr[0], arr[1], visited);
        getPointStr(depth + 1, sb.append(point), visited);
        visited[arr[0]][arr[1]] = false;
    }

    // 모든 경우의 수 탐색
    public static void combination(int depth, StringBuilder point, StringBuilder seed, boolean[][] visited) {
        // 한 글자씩 미리 비교
        if (depth != 0 && point.charAt(depth - 1) != pointStr.charAt(depth - 1)) {
            return;
        }
        if (depth == 9) {
            if (point.toString().equals(pointStr)) {
                answerList.add(seed.toString());
            }
            return;
        }

        for (int i = 0; i < 9; i++) {
            char target = seedStr.charAt(i);
            // 이미 사용된 알파벳이라면
            if (alpha[target - 'A']) continue;
            alpha[target - 'A'] = true;
            int[] arr = nodeList.get(target);
            visited[arr[0]][arr[1]] = true;
            point.append(checkPoint(arr[0], arr[1], visited));
            seed.append(target);
            combination(depth + 1, point, seed, visited);
            point.deleteCharAt(point.length() - 1);
            seed.deleteCharAt(seed.length() - 1);
            alpha[target - 'A'] = false;
            visited[arr[0]][arr[1]] = false;
        }

    }

    public static String checkPoint(int r, int c, boolean[][] visited) {
        int point = 0;

        // 행 검사
        boolean status = true;
        for (int i = 0; i < 3; i++) {
            if (!visited[r][i]) status = false;
        }
        if (status) point++;

        // 열 검사
        status = true;
        for (int i = 0; i < 3; i++) {
            if (!visited[i][c]) status = false;
        }
        if (status) point++;

        // 주 대각선 검사
        if ((r == 0 && c == 0) || (r == 1 && c == 1) || (r == 2 && c == 2)) {
            status = true;
            for (int i = 0; i < 3; i++) {
                if (!visited[i][i]) status = false;
            }
            if (status) point++;
        }

        // 반 대각선 검사
        if ((r == 0 && c == 2) || (r == 1 && c == 1) || (r == 2 && c == 0)) {
            status = true;
            for (int i = 0; i < 3; i++) {
                if (!visited[i][2 - i]) status = false;
            }
            if (status) point++;
        }

        return String.valueOf(point);
    }


}

class Node {
    char alpha;
    int row;
    int col;

    public Node(char alpha, int row, int col) {
        this.alpha = alpha;
        this.row = row;
        this.col = col;
    }
}

