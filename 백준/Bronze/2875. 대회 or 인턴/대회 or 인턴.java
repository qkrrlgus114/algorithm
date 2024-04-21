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
        int K = Integer.parseInt(sa[2]);

        int answer = 0;
        while(true){
            if(N-2 >= 0 && M-1 >= 0){
                N -= 2;
                M -= 1;
            }else break;

            if(N + M >= K) answer++;
            else break;



        }

        System.out.println(answer);
    }
}