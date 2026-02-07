import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Main {


    /*
     * 1. 첫번쨰 원소를 뽑아낸다.
     * 2. 왼쪽으로 한 칸씩 민다.
     * 3. 오른쪽으로 한 칸씩 민다.
     *
     * 1 2 3 4 5 6 7 8 9 10 - 1
     * 3 4 5 6 7 8 9 10 1 - 3
     * 10 1 3 4 5 6 7 8 - 4
     *
     * 우선 peek을 했을 때 그 숫자면 뽑아내면 된다.
     * peek을 했을 때 그 숫자가 아니라면 판단이 필요함.
     * 왼쪽으로 밀지, 오른쪽으로 밀지 어떻게 판단하지?
     *
     * 우선 양쪽으로 컨트롤이 가능한 Deque를 하나 둔다.
     * 앞에서 poll했을 때와, 뒤에서 poll 했을 때 둘다 비교해서 누가 빨리 목표값을 찾는지.
     * 1번이면 왼쪽, 2번이면 오른쪽이다.
     *
     * 1. 앞 데이터를 뒤로 넣음
     * 2. 뒤 데이터를 앞으로 넣음
     *
     * */

    static int answer = 0;
    static int N = 0;
    static int M = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);

        sa = bf.readLine().split(" ");
        int[] target = new int[sa.length];

        for (int i = 0; i < M; i++) {
            target[i] = Integer.parseInt(sa[i]);
        }

        // 메인 데큐 설정
        Deque<Integer> mainQ = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            mainQ.add(i);
        }

        for (int i = 0; i < M; i++) {
            // 첫번쨰 값이 타겟값이면 바로 제거
            if (mainQ.getFirst() == target[i]) {
                mainQ.pollFirst();
                continue;
            }
            calculator(mainQ, target[i]);
        }

        System.out.println(answer);
    }

    public static void calculator(Deque<Integer> mainQ, int target) {
        int leftCnt = 0;
        int rightCnt = 0;
        List<Integer> tempList = new ArrayList<>(mainQ);

        // 왼쪽으로 이동했을 때 최소값
        for (int i = 1; i < tempList.size(); i++) {
            leftCnt++;
            if (tempList.get(i) == target) {
                break;
            }
        }

        // 오른쪽으로 이동했을 때 최소값
        for (int i = tempList.size() - 1; i > 0; i--) {
            rightCnt++;
            if (tempList.get(i) == target) {
                break;
            }
        }

        // 오른쪽이 최소라면
        if (leftCnt > rightCnt) {
            while (true) {
                Integer num = mainQ.pollLast();
                if (num == target) break;
                mainQ.addFirst(num);
            }
            answer += rightCnt;
        } else {
            while (true) {
                Integer num = mainQ.pollFirst();
                if (num == target) break;
                mainQ.addLast(num);
            }
            answer += leftCnt;
        }

    }

}