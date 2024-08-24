import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String book = bf.readLine();
            map.put(book, map.getOrDefault(book, 0) + 1);
        }

        String name = "";
        int count = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > count) {
                name = entry.getKey();
                count = entry.getValue();
            } else if (count == entry.getValue() && entry.getKey().compareTo(name) < 0) {
                name = entry.getKey();
            }
        }

        System.out.println(name);
    }
}