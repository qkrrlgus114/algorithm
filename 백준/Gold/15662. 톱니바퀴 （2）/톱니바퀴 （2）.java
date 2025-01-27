import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static List<List<Integer>> tops = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(bf.readLine());
        for (int i = 0; i < T; i++) {
            char[] charArray = bf.readLine().toCharArray();
            List<Integer> top = new ArrayList<>();
            for (int j = 0; j < 8; j++) {
                top.add(charArray[j] - '0');
            }
            tops.add(top);
        }

        int K = Integer.parseInt(bf.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int index = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());

            // 왼쪽 톱니 돌려야 하는 개수
            int left = topCheck(index, 0);
            int leftIndex = index - 1;
            // 오른쪽 톱니 돌려야 하는 개수
            int right = topCheck(index, 1);
            int rightIndex = index + 1;

            // 현재 톱니 먼저 회전
            topRotation(index, dir);
            dir = dir == 1 ? -1 : 1;
            // 초기 톱니 방향 기억해놓기
            int initDir = dir;

            // 왼쪽 톱니를 돌려야 한다면 계속 돌림
            while (left != 0) {
                left--;
                topRotation(leftIndex--, dir);
                dir = dir == 1 ? -1 : 1;
            }

            dir = initDir;
            while (right != 0) {
                right--;
                topRotation(rightIndex++, dir);
                dir = dir == 1 ? -1 : 1;
            }
        }

        int reuslt = 0;
        // 모든 톱니를 돌면서 12시 방향이 S극인 톱니 개수 확인
        for (List<Integer> top : tops) {
            if (top.get(0) == 1) reuslt++;
        }

        System.out.println(reuslt);
    }

    // 톱니 회전
    private static void topRotation(int index, int dir) {
        List<Integer> top = tops.get(index);

        // 시계 방향인 경우
        if (dir == 1) {
            int last = top.get(7);
            for (int i = 6; i >= 0; i--) {
                top.set(i + 1, top.get(i));
            }
            top.set(0, last);
        }
        // 반시계 방향인 경우
        else {
            int first = top.get(0);
            for (int i = 1; i <= 7; i++) {
                top.set(i - 1, top.get(i));
            }
            top.set(7, first);
        }
    }

    // 톱니 확인(어디까지 돌아가는지)
    private static int topCheck(int index, int dir) {
        int cnt = 0;
        // 왼쪽
        if (dir == 0) {
            while (true) {
                if (index == 0) break;

                // 현재 톱니의 9시 방향 극
                int one = tops.get(index).get(6);
                // 왼쪽 톱니의 3시 방향 극
                int two = tops.get(index - 1).get(2);

                if (one == two) {
                    break;
                }
                cnt++;
                index--;
            }
        } else {
            while (true) {
                if (index == tops.size() - 1) break;

                // 현재 톱니의 3시 방향 극
                int one = tops.get(index).get(2);
                // 오른쪽 톱니의 9시 방향 극
                int two = tops.get(index + 1).get(6);

                if (one == two) {
                    break;
                }
                cnt++;
                index++;
            }
        }

        return cnt;
    }
}