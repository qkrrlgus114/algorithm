import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int K = Integer.parseInt(sa[1]);

        int[] arr = new int[N+1];
        sa = bf.readLine().split(" ");
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(sa[i-1]);
        }

        // 누적합 계산
        for(int i=1; i<=N; i++){
            arr[i] = arr[i-1] + arr[i];
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        long answer = 0;
        for(int j=1; j<=N; j++){
            answer += map.getOrDefault(arr[j] - K, 0);
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
        }

        System.out.println(answer);
    }
}

