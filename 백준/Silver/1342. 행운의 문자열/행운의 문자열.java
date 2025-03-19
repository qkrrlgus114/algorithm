import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // 재배치 문자열
    static char[] replaceStr;
    static int answer = 0;
    static int[] count = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = bf.readLine().toCharArray();
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - 'a']++;
        }

        replaceStr = new char[arr.length];

        if (replaceStr.length == 1) {
            System.out.println(1);
        } else {
            dfs(0);
            System.out.println(answer);
        }

    }

    public static void dfs(int depth) {
        if (depth == replaceStr.length) {
            for (int i = 0; i < replaceStr.length; i++) {
                if (check(i)) return;
            }
            answer++;
            return;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                count[i]--;
                replaceStr[depth] = (char) (i + 'a');
                dfs(depth + 1);
                count[i]++;
            }
        }
    }

    // 같으면 true, 다르면 false
    public static boolean check(int index) {
        if (index == 0) {
            return replaceStr[index] == replaceStr[index + 1];
        } else if (index == replaceStr.length - 1) {
            return replaceStr[index] == replaceStr[index - 1];
        } else {
            return replaceStr[index] == replaceStr[index - 1] || replaceStr[index] == replaceStr[index + 1];
        }
    }


}
