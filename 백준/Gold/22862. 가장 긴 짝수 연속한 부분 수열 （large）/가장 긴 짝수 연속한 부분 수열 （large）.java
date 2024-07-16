import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int K = Integer.parseInt(sa[1]);

        int[] S = new int[N];
        sa = bf.readLine().split(" ");
        for(int i=0; i<N; i++){
            S[i] = Integer.parseInt(sa[i]);
        }

        int answer = 0;
        int l = 0;
        int r = 0;
        int even = 0;
        while(r < N){
            // 짝수라면
            if(S[r] % 2 == 0){
                even++;
                r++;
                answer = Math.max(answer, even);
            }
            // 홀수라면
            else{
                if(K == 0){
                    while(true){
                        if(S[l] % 2 == 0){
                            even--;
                            l++;
                        }else{
                            K++;
                            l++;
                            break;
                        }
                    }
                }else{
                    K--;
                    r++;
                }
            }
        }

        System.out.println(answer);
    }
}