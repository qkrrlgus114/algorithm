import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        char[] wordArr = bf.readLine().toCharArray();

        List<Integer> nIdx = new ArrayList<>();
        for (int i = 0; i < wordArr.length; i++) {
            if (wordArr[i] == 'N') nIdx.add(i);
        }

        int answer = 0;

        for (int i = 0; i < nIdx.size(); i++) {
            // 왼쪽, 오른쪽에 A가 있냐?
            if (leftA(nIdx.get(i) - 1, wordArr) && rightA(nIdx.get(i) + 1, wordArr)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    // 왼쪽에 A가 있냐?
    private static boolean leftA(int n, char[] wordArr) {
        for (int i = n; i >= 0; i--) {
            if (wordArr[i] == 'N') return false;
            if (wordArr[i] == 'A') return true;

        }
        return false;
    }

    // 오른쪽에 A가 있냐?
    private static boolean rightA(int n, char[] wordArr) {
        for (int i = n; i < wordArr.length; i++) {
            if (wordArr[i] == 'N') return false;
            if (wordArr[i] == 'A') return true;
        }
        return false;
    }
}