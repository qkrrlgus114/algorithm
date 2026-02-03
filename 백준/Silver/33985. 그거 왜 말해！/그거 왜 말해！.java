import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        String T = bf.readLine();

        if (!T.substring(0, 1).equals("B") && !T.substring(T.length() - 1).equals("A")) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}