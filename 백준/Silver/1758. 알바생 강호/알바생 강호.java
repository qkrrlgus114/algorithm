import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/*
 * 손님이 주는 팁을 배열에 저장
 * 배열의 0번 인덱스가 1등
 * 이후 계산을 하면서 음수면 팁에 더하지 않음, 양수면 팁에 더함.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // 손님의 수
        int N = Integer.parseInt(bf.readLine());
        long tip = 0;
        int[] human = new int[N];
        int[] result = new int[N];

        for(int i=0; i<N; i++){
            human[i] = Integer.parseInt(bf.readLine());
        }

        Arrays.sort(human);
        int count = 0;
        for(int i=N-1; i>=0; i--){
            result[count++] = human[i];
        }

//         팁의 결과를 임시 저장
        long temp = 0;
        for(int i=0; i<N; i++){
            temp = result[i] - i;
            if(temp >= 0){
                tip += temp;
            }
        }

        System.out.println(tip);

    }
}