import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        char[] arr = new char[N];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(bf.readLine());
        }

        arr = sb.toString().toCharArray();

        sb.setLength(0);
        // 80자씩 저장해놓을 스트링빌더
        StringBuilder answer = new StringBuilder();

        int l = 0;
        int r = N - 1;
        while (l <= r) {
            if (arr[l] < arr[r]) {
                answer.append(arr[l]);
                l++;
            } else if (arr[l] > arr[r]) {
                answer.append(arr[r]);
                r--;
            } else {
                // 임시의 l, r을 만들어서 같지 않을 때까지 좁힌다.
                int tempL = l;
                int tempR = r;
                // 다른 곳을 찾았는지 상태로 저장
                boolean status = false;
                while (!status) {
                    tempL++;
                    tempR--;
                    // l이 r을 넘었으면 중단(더이상 확인할 수 없음)
                    if (tempL > tempR) break;
                    if (tempL == tempR) break;

                    if (arr[tempL] < arr[tempR]) {
                        answer.append(arr[l]);
                        l++;
                        status = true;
                    } else if (arr[tempL] > arr[tempR]) {
                        answer.append(arr[r]);
                        r--;
                        status = true;
                    }
                }

                // 결국 움직이지 못했다면 아무거나 골라서 좁힌다.(엇갈릴때까지 전부 같았다는 소리)
                if (!status) {
                    answer.append(arr[l]);
                    l++;
                }
            }

            if (answer.toString().length() == 80) {
                sb.append(answer).append("\n");
                answer.setLength(0);
            }
        }

        if (!answer.toString().isEmpty()) {
            sb.append(answer);
            answer.setLength(0);
        }

        System.out.println(sb);
    }
}