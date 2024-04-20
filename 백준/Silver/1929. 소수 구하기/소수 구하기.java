import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static boolean[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");

        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);
        num = new boolean[M+1];

        // 0과 1은 소수가 아님
        num[0] = num[1] = true;
        for(int i=2; i<= Math.sqrt(num.length); i++){
            if(num[i]) continue;
            for(int j = i*i; j<num.length; j += i){
                num[j] = true;
            }
        }

        for(int i=N; i<=M; i++){
            if(!num[i]) System.out.println(i);
        }


    }
}