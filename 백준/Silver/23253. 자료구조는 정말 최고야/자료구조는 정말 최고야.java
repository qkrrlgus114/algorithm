import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int curIdx = 1; // 꺼낼 숫자
    static int N;
    static int M;
    static List<Stack<Integer>> stacks;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);

        // 스택은 M개 필요함.
        stacks = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            stacks.add(new Stack<>());
        }

        for (int i = 0; i < M; i++) {
            int a = Integer.parseInt(bf.readLine());
            sa = bf.readLine().split(" ");
            Stack<Integer> stack = stacks.get(i);
            for (int j = 0; j < a; j++) {
                int value = Integer.parseInt(sa[j]);
                stack.add(value);
                map.put(value, i);
            }
        }
        boolean status = false;

        while (true) {
            if (curIdx > N) {
                status = true;
                break;
            }

            int stackIdx = map.get(curIdx);

            Stack<Integer> stack = stacks.get(stackIdx);

            if (stack.peek() == curIdx) {
                stack.pop();
                curIdx++;
            } else {
                break;
            }
        }

        System.out.println(status ? "Yes" : "No");

    }


}