import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(bf.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(bf.readLine());
            Map<String, Integer> map = new HashMap<>();
            List<String> styles = new ArrayList<>();

            for(int i=0; i<n; i++){
                String[] sa = bf.readLine().split(" ");
                String type = sa[1];

                if(!map.containsKey(type)) styles.add(type);
                map.put(type, map.getOrDefault(type, 0) + 1);
            }

            int answer = 1;

            for(int i=0; i<styles.size(); i++){
                answer *= map.get(styles.get(i)) + 1;
            }

            answer -= 1;
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}
