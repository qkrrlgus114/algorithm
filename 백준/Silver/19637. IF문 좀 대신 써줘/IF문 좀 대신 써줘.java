import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);

        List<Tier> tierList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            sa = bf.readLine().split(" ");
            tierList.add(new Tier(sa[0], Integer.parseInt(sa[1])));
        }

        tierList.sort((o1, o2) -> o1.value - o2.value);

        int[] arr = new int[M];
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int target = arr[i];

            int s = 0;
            int e = N - 1;
            String name = "";
            while (s <= e) {
                int m = (s + e) / 2;
                Tier tier = tierList.get(m);

                if (target <= tier.value) {
                    name = tier.name;
                    e = m - 1;
                } else {
                    s = m + 1;
                }
            }

            sb.append(name).append("\n");
        }

        System.out.println(sb);

    }

}

class Tier {
    String name;
    int value;

    public Tier(String name, int value) {
        this.name = name;
        this.value = value;
    }
}
