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
        int V = Integer.parseInt(sa[2]);

        if(A == V) System.out.println(1);
        else{
            if((V-A) % (A-B) == 0){
                System.out.println((V-A) / (A-B) + 1);
            }else{
                System.out.println((V-A) / (A-B) + 2);
            }
        }
    }

}
