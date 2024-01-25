import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String n = bf.readLine();
        int N = Integer.parseInt(n);
        String[] sa = bf.readLine().split(" ");
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < sa.length; i++) {
            if (!map.containsKey(sa[i])) {
                map.put(sa[i], 1);
            }
        }

        n = bf.readLine();
        int M = Integer.parseInt(n);
        sa = bf.readLine().split(" ");
        for (int i = 0; i < sa.length; i++) {
            if (!map.containsKey(sa[i])) {
                sb.append(0 + " ");
            } else {
                sb.append(1 + " ");
            }
        }

        System.out.println(sb);
    }

}