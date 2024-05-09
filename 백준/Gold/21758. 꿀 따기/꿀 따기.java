import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int N = Integer.parseInt(s);

        int[] honey = new int[N+2];
        int[] prefixSum = new int[N+1];
        int[] suffixSum = new int[N+1];

        String[] sa = bf.readLine().split(" ");
        for(int i=1; i<=N; i++){
            honey[i] = Integer.parseInt(sa[i-1]);
        }

        // prefix 계산
        for(int i=1; i<=N; i++){
            prefixSum[i] = prefixSum[i-1] + honey[i];
        }

        // suffix 계산
        for(int i=N-1; i>=0; i--){
            suffixSum[i] = suffixSum[i+1] + honey[i+1];
        }


        int answer = 0;
        // 벌통이 오른쪽이라고 가정
        for(int i=3; i<=N; i++){
            // 1번 벌
            int oneBee = prefixSum[N] - prefixSum[1] - (prefixSum[i-1] - prefixSum[i-2]);
            int twoBee = prefixSum[N] - prefixSum[i-1];
            // 최대 갱신
            answer = Math.max(answer, oneBee + twoBee);
        }

        // 벌통이 왼쪽이라고 가정
        for(int i=N-3; i>=0; i--){
            // 1번 벌
            int oneBee = suffixSum[0] - suffixSum[N-1] - (suffixSum[i+1] - suffixSum[i+2]);
            int twoBee = suffixSum[0] - suffixSum[i+1];
            // 최대 갱신
            answer = Math.max(answer, oneBee + twoBee);
        }

        // 벌통이 가운데 있는 경우
        for(int i=1; i<=N-1; i++){
            int oneBee = prefixSum[i+1] - prefixSum[1];
            int twoBee = suffixSum[i] - suffixSum[N-1];
            // 최대 갱신
            answer = Math.max(answer, oneBee + twoBee);
        }

        System.out.println(answer);
    }
}

