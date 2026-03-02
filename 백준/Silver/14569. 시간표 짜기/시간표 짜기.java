import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        List[] subjects = new List[N];
        for (int i = 0; i < N; i++) {
            subjects[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            String[] sa = bf.readLine().split(" ");
            for (int j = 1; j < sa.length; j++) {
                subjects[i].add(Integer.parseInt(sa[j]));
            }
        }

        StringBuffer sb = new StringBuffer();
        int k = Integer.parseInt(bf.readLine());
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < k; i++) {
            String[] sa = bf.readLine().split(" ");
            for (int j = 0; j < sa.length - 1; j++) {
                set.add(Integer.parseInt(sa[j + 1]));
            }

            int cnt = 0;

            for (int j = 0; j < subjects.length; j++) {
                List subject = subjects[j];
                boolean status = true;
                for (int q = 0; q < subject.size(); q++) {
                    if (!set.contains(subject.get(q))) {
                        status = false;
                        break;
                    }
                }

                if (status) cnt++;
            }

            sb.append(cnt).append("\n");
            set.clear();
        }

        System.out.println(sb);
    }


}