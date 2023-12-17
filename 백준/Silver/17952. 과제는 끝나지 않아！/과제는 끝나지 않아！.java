import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;



/*
 * 1. 과제는 최근에 나온 순으로, 나오면 바로 함
 * 2. 과제중에 새로운 과제가 나오면 중단하고 새로운 과제 진행
 * 3. 과제가 끝나면 이전 과제로 돌아감.
 * 스택 이용하면 가능하지 않을까?
 * */


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        int N = Integer.parseInt(s);

        int result = 0;

        // 점수 스택과 시간 스택을 2개 설정
        Stack<Integer> point = new Stack<>();
        Stack<Integer> time = new Stack<>();

        for (int k = 0; k < N; k++) {
            String[] input = bf.readLine().split(" ");
            // 0이면 건너뜀.
            if (input[0].equals("1")) {
                // 포인트를 스택에 넣음
                point.push(Integer.parseInt(input[1]));
                // 시간을 스택에 넣음
                time.push(Integer.parseInt(input[2]));
            }

            if(time.size() != 0){
                Integer targetTime = time.pop();

                // 시간이 1이면 과제가 오늘 끝나니깐 점수를 더해줌
                if (targetTime == 1) {
                    result += point.pop();
                } else {
                    time.push(--targetTime);
                }
            }


        }

        System.out.println(result);

    }
}