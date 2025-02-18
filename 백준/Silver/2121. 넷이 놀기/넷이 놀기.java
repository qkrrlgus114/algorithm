import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Node> list = new ArrayList<>();
    static int X;
    static int Y;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        String[] sa = bf.readLine().split(" ");
        X = Integer.parseInt(sa[0]); // 가로
        Y = Integer.parseInt(sa[1]); // 세로

        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            sa = bf.readLine().split(" ");
            list.add(new Node(Integer.parseInt(sa[0]), Integer.parseInt(sa[1])));
        }

        list.sort((o1, o2) -> {
            if (o1.x == o2.x) {
                return o1.y - o2.y;
            }
            return o1.x - o2.x;
        });

        int answer = 0;

        for (int i = 0; i < N; i++) {
            // 3개의 경우를 전부 확인해야함. 즉 3번의 이분탐색 진행
            Node node = list.get(i);
            if (binarySearch(i, N - 1, node.x + X, node.y) &&
                    binarySearch(i, N - 1, node.x, node.y + Y) &&
                    binarySearch(i, N - 1, node.x + X, node.y + Y)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static boolean binarySearch(int s, int e, int x, int y) {
        if (s > e) return false;
        int m = (s + e) / 2;

        int checkY = list.get(m).y;
        int checkX = list.get(m).x;

        if (checkX < x) {
            return binarySearch(m + 1, e, x, y);
        } else if (checkX > x) {
            return binarySearch(s, m - 1, x, y);
        } else {
            if (checkY < y) {
                return binarySearch(m + 1, e, x, y);
            } else if (checkY > y) {
                return binarySearch(s, m - 1, x, y);
            } else {
                return true;
            }
        }
    }

}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}