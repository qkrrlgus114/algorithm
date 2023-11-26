import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] s = bf.readLine().split(" ");

        int numA = Integer.parseInt(s[0]);
        int numB = Integer.parseInt(s[1]);

        if (numA < numB) {
            System.out.println("<");
        } else if (numA > numB) {
            System.out.println(">");
        } else {
            System.out.println("==");
        }
    }
}
