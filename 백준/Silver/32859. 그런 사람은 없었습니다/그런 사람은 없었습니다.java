import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);

        int S = Integer.parseInt(bf.readLine());

        // 0의 개수 누적합
        int[] prefix = new int[M + 1];
        // 0인 곳의 인덱스
        int[] arr = new int[N + 1];
        Arrays.fill(arr, -1);

        List<Node> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            sa = bf.readLine().split(" ");
            int j = Integer.parseInt(sa[0]);
            int t = Integer.parseInt(sa[1]);

            list.add(new Node(j, t));

            if (t == 0) {
                prefix[i + 1] = prefix[i] + 1;
                arr[j] = i;
            } else {
                prefix[i + 1] = prefix[i];
            }
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int j = list.get(i).j;
            int t = list.get(i).t;

            if (t == 1) {
                // j가 0인 곳의 인덱스를 찾는다.
                int index = arr[j];
                if (index == -1) {
                    if (prefix[M] - prefix[i] >= S) answer.add(j);
                } else {
                    if (prefix[index + 1] - prefix[i] > S) answer.add(j);
                }
            }
        }

        if (answer.isEmpty()) System.out.println(-1);
        else {
            Collections.sort(answer);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < answer.size(); i++) {
                sb.append(answer.get(i)).append("\n");
            }
            System.out.println(sb);
        }
    }
}

class Node {
    int j;
    int t;

    public Node(int j, int t) {
        this.j = j;
        this.t = t;
    }
}