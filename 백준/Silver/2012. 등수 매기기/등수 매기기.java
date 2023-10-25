import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        Long[] student = new Long[N];

        for(int i=0; i<N; i++){
            student[i] = Long.valueOf(bf.readLine());
        }

        Arrays.sort(student);

        // 정답
        Long result = 0L;
        // 등수
        int count = 1;

        for(int i=0; i<N; i++){
            result += Math.abs(count - student[i]);
            count += 1;
        }

        System.out.println(result);
    }
}