import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int X;
    static int N;
    static int minX; // 5% 득표수. 이건 넘어야함
    static List<Node> nodes = new ArrayList<>();
    static Map<String, Integer> chips = new HashMap<>();


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        X = Integer.parseInt(bf.readLine());
        N = Integer.parseInt(bf.readLine());

        minX = (int) (X * 0.05);

        List<String[]> list = new ArrayList<>(); // 계산 대상
        for (int i = 0; i < N; i++) {
            String[] sa = bf.readLine().split(" ");
            int value = Integer.parseInt(sa[1]);

            if (value < minX) continue;
            list.add(new String[]{sa[0], sa[1]});
        }

        // 1~14로 나눈 득표율 게산
        for (int i = 0; i < list.size(); i++) {
            String[] target = list.get(i);
            // 이름만 넣어둠
            chips.put(target[0], 0);

            int vote = Integer.parseInt(target[1]);

            // 1~14로 나눈 득표율 게산
            for (int j = 1; j <= 14; j++) {
                nodes.add(new Node(target[0], (double) vote / j));
            }
        }

        nodes.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return (int) (o2.value - o1.value);
            }
        });

        int idx = 0;
        for (int i = 0; i < nodes.size(); i++) {
            if (idx >= 14) break;
            Node node = nodes.get(idx);
            chips.put(node.name, chips.get(node.name) + 1);

            idx++;
        }


        List<String> names = new ArrayList<>(chips.keySet());
        Collections.sort(names);

        StringBuilder sb = new StringBuilder();
        for (String name : names) {
            sb.append(name).append(" ").append(chips.get(name)).append("\n");
        }

        System.out.println(sb);

    }


}

class Node {
    String name;
    Double value;

    public Node(String name, Double value) {
        this.name = name;
        this.value = value;
    }

    public String toString() {
        return name + " " + value;
    }
}