import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        String[] sa = bf.readLine().split(" ");
        int A = Integer.parseInt(sa[0]);
        int B = Integer.parseInt(sa[1]);

        int count = (A / 2) + B;

        if(N >= count) System.out.println(count);
        else System.out.println(N);


    }
}

