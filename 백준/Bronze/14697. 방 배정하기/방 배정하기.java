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
        int C = Integer.parseInt(sa[2]);
        int N = Integer.parseInt(sa[3]);

        boolean check = false;
        for(int i=0; i<=N/A; i++){
            for(int j=0; j<=N/B;j ++){
                for(int k=0; k<=N/C; k++){
                    if(i*A + j*B + k*C == N) {
                        check = true;
                        break;
                    }
                }
            }
        }
        System.out.println(check ? 1 : 0);
    }
}