import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        // 접시의 수
        int N = Integer.parseInt(sa[0]);
        // 초밥의 가짓수
        int d = Integer.parseInt(sa[1]);
        // 연속해서 먹는 접시의 수
        int k = Integer.parseInt(sa[2]);
        // 쿠폰 번호
        int c = Integer.parseInt(sa[3]);

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        Map<Integer, Integer> map = new HashMap<>();
        // 처음에 초밥을 k 선택
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int s = 0;
        int e = k - 1;
        int result = map.containsKey(c) ? map.size() : map.size() + 1;

        // 구간을 옮기면서 탐색
        while (e < N - 1) {
            e++;
            map.put(arr[e], map.getOrDefault(arr[e], 0) + 1);

            if (map.get(arr[s]) == 1) {
                map.remove(arr[s]);
            } else {
                map.put(arr[s], map.get(arr[s]) - 1);
            }
            s++;
            
            if (!map.containsKey(c)) {
                result = Math.max(result, map.size() + 1);
            } else {
                result = Math.max(result, map.size());
            }
        }

        e = -1;
        // k - 1번을 더 확인해야함.
        for (int i = 0; i <= k - 1; i++) {
            e++;
            map.put(arr[e], map.getOrDefault(arr[e], 0) + 1);

            if (map.get(arr[s]) == 1) {
                map.remove(arr[s]);
            } else {
                map.put(arr[s], map.get(arr[s]) - 1);
            }
            s++;

            if (!map.containsKey(c)) {
                result = Math.max(result, map.size() + 1);
            } else {
                result = Math.max(result, map.size());
            }
        }
        System.out.println(result);
    }
}