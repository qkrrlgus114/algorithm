import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] s = bf.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        // 동전의 개수
        int sum = 0;

        int[] coin = new int[N];
        for(int i=0; i<N; i++){
            String q = bf.readLine();
            coin[i] = Integer.parseInt(q);
        }

        for(int i=N-1; i>=0; i--){
            if(K==0){
                break;
            }
            if(K >= coin[i]){
                int temp = K / coin[i];
                sum += temp;
                K -= temp * coin[i];
            }
        }

        System.out.println(sum);
    }
}