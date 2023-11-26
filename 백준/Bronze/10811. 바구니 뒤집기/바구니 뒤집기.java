import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.OptionalInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] s = bf.readLine().split(" ");

        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        int[] num = new int[N];
        for(int i=1; i<=N; i++){
            num[i-1] = i;
        }

        for(int i=0; i<M; i++){
            String[] s1 = bf.readLine().split(" ");
            int a = Integer.parseInt(s1[0]);
            int b = Integer.parseInt(s1[1]);

            while((a != b) && (a < b)){
                int temp = num[b-1];
                num[b-1] = num[a-1];
                num[a-1] = temp;
                a++;
                b--;
            }
        }

        for(Integer i : num){
            System.out.print(i + " ");
        }

    }
}