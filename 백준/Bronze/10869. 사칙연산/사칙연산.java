import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] s = bf.readLine().split(" ");
        System.out.println(Integer.parseInt(s[0]) + Integer.parseInt(s[1]));
        System.out.println(Integer.parseInt(s[0]) - Integer.parseInt(s[1]));
        System.out.println(Integer.parseInt(s[0]) * Integer.parseInt(s[1]));
        System.out.println(Integer.parseInt(s[0]) / Integer.parseInt(s[1]));
        System.out.println(Integer.parseInt(s[0]) % Integer.parseInt(s[1]));


    }
}