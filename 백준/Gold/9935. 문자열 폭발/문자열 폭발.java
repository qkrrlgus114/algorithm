import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String string = bf.readLine();
        String bomb = bf.readLine();

        int m = bomb.length();

        Stack<Character> s = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            s.add(string.charAt(i));
            if (s.size() < m) continue;

            boolean isSame = true;
            for (int j = 0; j < m; j++) {
                if (s.get(s.size() - m + j) != bomb.charAt(j)) {
                    isSame = false;
                    break;
                }
            }

            if (isSame) {
                for (int j = 0; j < m; j++) {
                    s.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char c : s){
            sb.append(c);
        }
        if(sb.length() == 0) System.out.println("FRULA");
        else System.out.println(sb);

    }
}
