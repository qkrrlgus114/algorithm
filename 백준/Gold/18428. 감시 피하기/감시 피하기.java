import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int N;
    static String[][] board;
    static boolean[][] visited;
    static List<Node> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        board = new String[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] sa = bf.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = sa[j];
                if (board[i][j].equals("T")) {
                    list.add(new Node(i, j));
                }
            }
        }

        dfs(0, 0, 0);

        System.out.println("NO");

    }

    public static void dfs(int y, int x, int depth) {
        if (depth == 3) {
            // 검사 진행
            if (teacherCheck()) {
                System.out.println("YES");
                System.exit(0);
            }
            return;
        }

        if (x >= N) {
            x = 0;
            y++;
        }

        for (int i = y; i < N; i++) {
            for (int j = (i == y ? x : 0); j < N; j++) {
                if (board[i][j].equals("X") && !visited[i][j]) {
                    visited[i][j] = true;
                    board[i][j] = "W"; // 벽으로 갱신
                    dfs(i, j + 1, depth + 1);
                    visited[i][j] = false;
                    board[i][j] = "X";
                }
            }
        }

    }

    public static boolean teacherCheck() {
        for (Node node : list) {
            // 상
            for (int i = node.y - 1; i >= 0; i--) {
                if (board[i][node.x].equals("W")) break;
                if (board[i][node.x].equals("S")) return false;
            }
            // 하
            for (int i = node.y + 1; i < N; i++) {
                if (board[i][node.x].equals("W")) break;
                if (board[i][node.x].equals("S")) return false;
            }
            // 좌
            for (int i = node.x - 1; i >= 0; i--) {
                if (board[node.y][i].equals("W")) break;
                if (board[node.y][i].equals("S")) return false;
            }
            // 우
            for (int i = node.x + 1; i < N; i++) {
                if (board[node.y][i].equals("W")) break;
                if (board[node.y][i].equals("S")) return false;
            }
        }
        return true;
    }

}

// 선생님 좌표
class Node {
    int y;
    int x;

    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public String toString() {
        return y + " : " + x
                ;
    }
}
