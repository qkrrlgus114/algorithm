import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");

        int N = Integer.parseInt(sa[0]);
        int K = Integer.parseInt(sa[1]);

        int[] arr = new int[N];
        sa = bf.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(sa[i]);
        }

        int[] prefixSum = new int[N + 1];
        for (int i = 0; i < N; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }

        // 누적합 값의 개수를 카운트
        Map<Integer, Integer> countMap = new HashMap<>();
        // prefixSum[i] == K인 경우가 생길 수 있기에 0을 미리 하나 더해준다.
        // prefixSum[i] - K = 0이 되기 때문.
        countMap.put(0, 1);
        // 정답
        long answer = 0;

        for (int i = 1; i <= N; i++) {
            answer += countMap.getOrDefault(prefixSum[i] - K, 0);
            countMap.put(prefixSum[i], countMap.getOrDefault(prefixSum[i], 0) + 1);
        }

        System.out.println(answer);
    }

}

