import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        String s = bf.readLine();
        int N = Integer.parseInt(s);

        for(int i=1; i<=500; i++){
            for(int j=1; j<=500; j++){
                if(i == j) continue;
                if(i*i == (j*j) + N) answer++;
            }
        }

        System.out.println(answer);

    }
}