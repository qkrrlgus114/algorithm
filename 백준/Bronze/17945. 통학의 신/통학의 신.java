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
        
        for(int i=-1000; i<=1000; i++){
            if(i * i + 2 * A * i + B == 0) System.out.print(i + " ");
        }

    }
}