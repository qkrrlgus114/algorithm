import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {


    static int answer, N, M, L, K = 0;
    static List<Node> nodeList = new ArrayList<>(); // 별똥별의 좌표

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]) + 1;
        M = Integer.parseInt(sa[1]) + 1;
        L = Integer.parseInt(sa[2]) + 1;
        K = Integer.parseInt(sa[3]);

        for (int i = 0; i < K; i++) {
            sa = bf.readLine().split(" ");
            nodeList.add(new Node(Integer.parseInt(sa[1]), Integer.parseInt(sa[0])));
        }

        for (Node first : nodeList) {
            for (Node second : nodeList) {
                int x = first.x;
                int y = second.y;
                int cnt = 0;

                for (Node third : nodeList) {
                    if (x <= third.x && third.x <= x + L && y <= third.y && third.y <= y + L) {
                        cnt++;
                    }
                }

                answer = Math.max(cnt, answer);
            }
        }

        System.out.println(K - answer);
    }


}

class Node {
    int y;
    int x;

    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
