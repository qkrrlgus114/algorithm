import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Main {

    static int[] count = new int[101];
    static List<Integer> list = new ArrayList<>();
    static char[] arr;
    static int n = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();

        n = s.length() > 9 ? 9 + (s.length() - 9) / 2 : s.length();

        arr = s.toCharArray();

        dfs(0);
    }

    // check -> 이전 수를 건너뛰었는지
    public static void dfs(int depth) {
        // 종료 조건
        if(depth >= arr.length){
            for(int i : list){
                System.out.print(i + " ");
            }
            System.exit(0);
        }

        // 재귀 조건
        int one = strToInteger(depth, 1);
        if(one <= n && count[one] == 0){
            count[one]++;
            list.add(one);
            dfs(depth + 1);
            count[one]--;
            list.remove(list.size() - 1);
        }

        if(depth + 1 >= arr.length) return;
        int two = strToInteger(depth, 2);
        if(two <= n && count[two] == 0){
            count[two]++;
            list.add(two);
            dfs(depth + 2);
            count[two]--;
            list.remove(list.size() - 1);
        }

    }

    // 숫자 변환 메서드
    public static int strToInteger(int start, int length) {
        int result = 0;
        for (int i = start; i < start + length; i++) {
            result *= 10;
            result += arr[i] - '0';
        }
        return result;
    }
}