import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int G = Integer.parseInt(bf.readLine());

        // 현재 몸무게
        int N = 1;
        // 기억 몸무게
        int M = 1;
        // 가능한 몸무게를 저장할 리스트
        List<Integer> list = new ArrayList<>();
        while (N <= G || M <= G) {
            if ((N * N) - (M * M) == G) {
                list.add(N);
                N++;
                M++;
            } else if ((N * N) - (M * M) < G) {
                N++;
            } else {
                M++;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (list.isEmpty()) {
            sb.append("-1");
        } else {
            list.forEach(num -> sb.append(num).append("\n"));
        }

        System.out.println(sb);

    }
}