import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    static int[] memo = new int[50001];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        initMemo();
        int N = Integer.parseInt(bf.readLine());

        for(int i=1; i<=N; i++){
            if(memo[i] == 1) continue;

            int value = Integer.MAX_VALUE;
            for(int j=1; j<=(int) Math.sqrt(i); j++){
                if(value > memo[(int) Math.pow(j, 2)] + memo[i - (int) Math.pow(j, 2)]){
                    value = memo[(int) Math.pow(j, 2)] + memo[i - (int) Math.pow(j, 2)];
                }
            }

            memo[i] = value;
        }

        System.out.println(memo[N]);
    }

    private static void initMemo(){
        for(int i=1; i <= Math.sqrt(50000); i++){
            memo[(int)Math.pow(i, 2)] = 1;
        }
    }
}