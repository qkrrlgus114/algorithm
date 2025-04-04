import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<Integer> list = new ArrayList<>();
    static int[] arr = new int[]{4, 7};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");


        String A = sa[0];
        String B = sa[1];
        int a = Integer.parseInt(A);
        int b = Integer.parseInt(B);
        if (a == 1000000000) {
            a--;
            A = String.valueOf(a);
        }
        if (b == 1000000000) {
            b--;
            B = String.valueOf(b);
        }
        int answer = 0;

        for (int i = A.length(); i <= B.length(); i++) {
            dfs(new StringBuilder(), i);
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) >= a && list.get(i) <= b) answer++;
        }

        System.out.println(answer);
    }

    // 두 수가 길이가 같은 경우 해당 길이의 경우의 수만 구한다.
    public static void dfs(StringBuilder sb, int length) {
        if (sb.length() == length) {
            list.add(Integer.parseInt(sb.toString()));
            return;
        }

        for (int i = 0; i < 2; i++) {
            dfs(sb.append(arr[i]), length);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

}
