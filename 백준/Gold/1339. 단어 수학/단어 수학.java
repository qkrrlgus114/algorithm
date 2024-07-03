import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    // 가장 높은 인덱스, 나온 횟수
    static int[][] arr = new int[26][3];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        String[] sa = new String[N];
        int[] match = new int[26];

        Long answer = 0L;

        for (int i = 0; i < N; i++) {
            String s = bf.readLine();
            sa[i] = s;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                int index = s.length() - j;
                arr[c - 'A'][0] += (int) Math.pow(10, index - 1); // 위치 값 누적
                arr[c - 'A'][1]++;
                arr[c - 'A'][2] = c;
            }
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        // 매칭 시작
        int num = 9;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][2] == 0) break;
            match[arr[i][2] - 'A'] = num--;
        }

        for (int i = 0; i < N; i++) {
            String s = sa[i];
            int value = 0;
            for (int j = s.length() - 1; j >= 0; j--) {
                char c = s.charAt(j);
                int number = match[c - 'A'];
                value += number * ((int) Math.pow(10, s.length() - j - 1));
            }
            answer += value;
        }

        System.out.println(answer);
    }
}
