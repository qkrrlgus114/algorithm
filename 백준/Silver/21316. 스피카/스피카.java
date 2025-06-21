import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        List<Integer>[] list = new List[13];
        for (int i = 0; i < 13; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < 12; i++) {
            String[] sa = bf.readLine().split(" ");
            int s = Integer.parseInt(sa[0]);
            int e = Integer.parseInt(sa[1]);

            list[s].add(e);
            list[e].add(s);
        }

        for (int i = 1; i < 13; i++) {
            if (list[i].size() != 3) continue;

            boolean s1 = false;
            boolean s2 = false;
            boolean s3 = false;

            for (Integer v : list[i]) {
                switch (list[v].size()) {
                    case 1:
                        s1 = true;
                        break;
                    case 2:
                        s2 = true;
                        break;
                    case 3:
                        s3 = true;
                        break;
                }
            }

            if (s1 && s2 && s3) {
                System.out.println(i);
            }
        }
    }
}