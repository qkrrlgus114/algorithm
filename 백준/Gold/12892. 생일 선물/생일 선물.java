import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int P = Integer.parseInt(sa[0]);
        int D = Integer.parseInt(sa[1]);

        List<Node> list = new ArrayList<>();
        for (int i = 0; i < P; i++) {
            sa = bf.readLine().split(" ");
            list.add(new Node(Long.parseLong(sa[0]), Long.parseLong(sa[1])));
        }

        list.sort((o1, o2) -> (int) (o1.p - o2.p));

        int l = 0;
        int r = -1;
        long sum = 0;
        long answer = 0;

        while (r < P - 1) {
            r++;
            sum += list.get(r).v;

            // 가장 큰 선물과 작은 선물의 가격 차이가 D 이상이라면
            if (list.get(r).p - list.get(l).p >= D) {
                while (list.get(r).p - list.get(l).p >= D) {
                    sum -= list.get(l).v;
                    l++;
                }
            }
            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }

    public static class Node {
        long p;
        long v;

        public Node(long p, long v) {
            this.p = p;
            this.v = v;
        }
    }
}