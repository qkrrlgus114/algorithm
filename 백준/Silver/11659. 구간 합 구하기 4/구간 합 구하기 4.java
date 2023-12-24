import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] s = bf.readLine().split(" ");
        int M = Integer.parseInt(s[1]);

        s = bf.readLine().split(" ");
        // 합배열
        int[] S = new int[s.length + 1];
        S[0] = 0;

        // 합배열 계산
        for(int i=1; i<S.length; i++){
            S[i] = Integer.parseInt(s[i-1]) + S[i-1];
        }

        for(int k=0; k<M; k++){
            s = bf.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);

            if(a == 0){
                System.out.println(S[b]);
            }else{
                System.out.println(S[b] - S[a - 1]);
            }
        }

    }
}