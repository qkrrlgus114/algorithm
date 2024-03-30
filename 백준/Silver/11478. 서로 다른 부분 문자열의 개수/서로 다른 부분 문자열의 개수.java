import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        int N = s.length();

        HashSet<String> set = new HashSet<>();

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= N - i; j++) {
                set.add(s.substring(j, j+i));
            }
        }

        System.out.println(set.size());
    }


}



