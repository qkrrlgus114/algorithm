import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int N = Integer.parseInt(s);

        int[][] server = new int[N][N];
        long sum = 0;
        int max = 0;

        for(int i=0; i<N; i++){
            String[] sa = bf.readLine().split(" ");
            for(int j=0; j<N; j++){
                server[i][j] = Integer.parseInt(sa[j]);
                sum += server[i][j];
                max = Math.max(max, server[i][j]);
            }
        }

        long half = sum % 2 == 0 ? sum / 2 : sum / 2 + 1;
        long l = 1;
        long r = max;
        long answer = 0;

        while(l <= r){
            long mid = (l + r) / 2;
            long count = 0;

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(server[i][j] >= mid) count += mid;
                    else count += server[i][j];
                }
            }

            if(count >= half){
                answer = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        System.out.println(answer);
    }

}

