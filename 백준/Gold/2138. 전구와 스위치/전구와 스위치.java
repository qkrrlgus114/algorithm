import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static int N;
    static String status;
    static int push_count, no_push_count;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        N = Integer.parseInt(s);

        status = bf.readLine();

        // 현재 상태
        boolean[] cur_arr = new boolean[N];
        cur_arr = input(cur_arr);
        // 초반에 누른 스위치
        boolean[] temp1 = new boolean[N];
        temp1 = input(temp1);
        temp1 = switchOn(temp1, 0);
        push_count = 1;
        // 초반에 안 누른 스위치
        boolean[] temp2 = new boolean[N];
        temp2 = input(temp2);
        no_push_count = 0;

        // 목표하는 상태
        status = bf.readLine();
        boolean[] target_arr = new boolean[N];
        target_arr = input(target_arr);

        boolean check1 = false;
        boolean check2 = false;
        for(int i=1; i<N; i++){
            // 둘 중 하나라도 목표와 같으면 종료
            if(Arrays.equals(temp1, target_arr)) {
                check1 = true;
                break;
            }
            if(Arrays.equals(temp2, target_arr)){
                check2 = true;
                break;
            }
            // temp1이 다르면 누름
            if(temp1[i-1] != target_arr[i-1]){
                temp1 = switchOn(temp1, i);
                push_count++;
            }
            // temp2이 다르면 누름
            if(temp2[i-1] != target_arr[i-1]){
                temp2 = switchOn(temp2, i);
                no_push_count++;
            }
        }
        if(Arrays.equals(temp1, target_arr) || check1) System.out.println(push_count);
        else if(Arrays.equals(temp2, target_arr) || check2) System.out.println(no_push_count);
        else System.out.println("-1");
    }

    // 입력
    public static boolean[] input(boolean[] arr) {
        for (int i = 0; i < N; i++) {
            arr[i] = status.charAt(i) == '0' ? false : true;
        }
        return arr;
    }

    // 스위치 누름
    public static boolean[] switchOn(boolean[] arr, int index) {
        if (index == 0) {
            for (int i = 0; i <= 1; i++) {
                arr[i] = !arr[i];
            }
        } else if (index == N - 1) {
            for (int i = N - 2; i <= N - 1; i++) {
                arr[i] = !arr[i];
            }
        } else {
            for (int i = index - 1; i <= index + 1; i++) {
                arr[i] = !arr[i];
            }
        }
        return arr;
    }

}


