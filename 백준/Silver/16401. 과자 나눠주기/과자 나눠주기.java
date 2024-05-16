import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");
        int M = Integer.parseInt(sa[0]);
        int N = Integer.parseInt(sa[1]);

        int[] snacks = new int[N];
        int max = 0;
        sa = bf.readLine().split(" ");
        for(int i=0; i<N; i++){
            snacks[i] = Integer.parseInt(sa[i]);
            max = Math.max(snacks[i], max);
        }

        int answer = 0;
        int l = 1;
        int r = max;

        while(l <= r){
            int mid = (l + r) / 2;
            int count = 0;
            for(int snack : snacks){
                count += snack / mid;
            }

            if(count >= M){
                answer = Math.max(answer, mid);
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }

        System.out.println(answer);



    }

}

