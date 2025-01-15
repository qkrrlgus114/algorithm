import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        Map<Integer, Integer> country = new HashMap<>();
        List<Node> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] sa = bf.readLine().split(" ");
            country.putIfAbsent(Integer.parseInt(sa[0]), 0);
            list.add(new Node(Integer.parseInt(sa[0]), Integer.parseInt(sa[1]), Integer.parseInt(sa[2])));
        }

        Collections.sort(list, (o1, o2) -> {
            return o2.getPoint() - o1.getPoint();
        });

        StringBuilder sb = new StringBuilder();

        list.forEach(l -> {
            int team = l.getTeam();
            int index = l.getIndex();

            if (country.get(team) <= 1) {
                sb.append(team).append(" ").append(index);
                country.put(team, country.get(team) + 1);
                sb.append("\n");
            }
        });

        String[] split = sb.toString().split("\n");
        for (int i = 0; i < 3; i++) {
            System.out.println(split[i]);
        }

    }

}

class Node {
    private int team;
    private int index;
    private int point;

    public int getPoint() {
        return point;
    }

    public int getTeam() {
        return team;
    }

    public int getIndex() {
        return index;
    }

    public Node(int team, int index, int point) {
        this.team = team;
        this.index = index;
        this.point = point;
    }

}