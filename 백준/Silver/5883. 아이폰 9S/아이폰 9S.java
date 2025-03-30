import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N]; // 사람들이 원하는 용량
        List<Integer> list = new ArrayList<>(); // 용량을 중복 없이 저장
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
            if (!list.contains(arr[i])) list.add(arr[i]);
        }

        int answer = 0;
        for (Integer want : list) {
            int length = 0; // 현재까지 누적 길이
            int value = 0; // 현재 고른 용량
            for (int i = 0; i < N; i++) {
                if (arr[i] == want) continue;
                if (value != arr[i]) {
                    answer = Math.max(answer, length);
                    length = 1;
                    value = arr[i];
                } else {
                    length++;
                }
            }
            answer = Math.max(answer, length);
        }

        System.out.println(answer);


    }
}