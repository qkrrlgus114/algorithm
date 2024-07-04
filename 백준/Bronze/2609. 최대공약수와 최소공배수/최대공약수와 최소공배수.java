import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);

        int a = gcd(N, M);
        int b = N * M / a;

        System.out.println(a);
        System.out.println(b);

    }

    private static int gcd(int a, int b){
        int r = 0;
        while(b > 0){
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

}
