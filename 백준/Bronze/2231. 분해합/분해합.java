import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int N = Integer.parseInt(s);
        boolean check = false;

        for(int i=1; i<=N; i++){
            int sum = i;
            int num = i;
            while(num != 0){
                sum += num % 10;
                num /= 10;
            }
            if(sum == N){
                check = true;
                System.out.println(i);
                break;
            }
        }
        if(!check) System.out.println(0);
    }
}