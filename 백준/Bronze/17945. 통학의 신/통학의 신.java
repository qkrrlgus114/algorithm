import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");

        int A = Integer.parseInt(sa[0]);
        int B = Integer.parseInt(sa[1]);

        int root = (int) Math.sqrt(A * A - B);
        int num1 = -A - root;
        int num2 = -A + root;

        if(num1 == num2){
            System.out.println(num1);
        }else{
            System.out.println(Math.min(num1, num2) + " " + Math.max(num1, num2));
        }

    }
}