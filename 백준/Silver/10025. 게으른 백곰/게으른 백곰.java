import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");

        int N = Integer.parseInt(sa[0]);
        int K = Integer.parseInt(sa[1]);

        long[] arr = new long[1000002];
        int max = 0;

        for(int i=0; i<N; i++){
            sa = bf.readLine().split(" ");
            int g = Integer.parseInt(sa[0]);
            int x = Integer.parseInt(sa[1]);

            arr[x] = g;
            max = Math.max(max, x);
        }

        // 누적합 구함
        for(int i=1; i<=1000001; i++){
            arr[i] = arr[i-1] + arr[i];
        }

        // l, r 슬라이딩 윈도우
        int l = 1;
        int r = 2*K + 1;
        long answer = r<=1000000 ? arr[r] : arr[1000000];

        while(r <= 1000001){
            long sum = arr[r] - arr[l-1];
            answer = Math.max(answer, sum);

            r++;
            l++;
        }

        System.out.println(answer);

    }
}

