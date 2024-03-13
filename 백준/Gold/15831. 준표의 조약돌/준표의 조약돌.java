import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int B_count;
    static int W_count;
    static int max_length;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int B = Integer.parseInt(sa[1]);
        int W = Integer.parseInt(sa[2]);

        String road = bf.readLine();

        B_count = 0;
        W_count = 0;
        max_length = 0;
        int l = 0;
        int r = 0;

        while(r < N){
            if(B_count > B){
                if(road.charAt(l) == 'W') W_count--;
                else B_count--;
                l++;
            }else{
                if(road.charAt(r) == 'W') W_count++;
                else B_count++;
                r++;
            }
            if(W_count >= W && B_count <= B){
                max_length = Math.max(max_length, r - l);
            }
        }

        System.out.println(max_length);
    }
}