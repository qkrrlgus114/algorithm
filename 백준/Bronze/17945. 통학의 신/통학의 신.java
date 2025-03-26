import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int A = Integer.parseInt(sa[0]);
        int B = Integer.parseInt(sa[1]);

        // 정답 리스트
        List<Integer> answers = new ArrayList<>();

        for (int i = -1000; i <= 1000; i++) {
            for (int j = i; j <= 1000; j++) {
                if (i * j == B && i + j == A * 2) {
                    // 중근이면
                    if (i == j) {
                        answers.add(-1 * i);
                    } else {
                        answers.add(-1 * i);
                        answers.add(-1 * j);
                    }
                }
            }
        }

        Collections.sort(answers);
        StringBuilder sb = new StringBuilder();
        for (Integer answer : answers) {
            sb.append(answer).append(" ");
        }

        System.out.println(sb);
    }
}
