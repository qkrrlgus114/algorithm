import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] fruit = new int[10];
    static int[] arr;
    static int max = Integer.MIN_VALUE;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String n = bf.readLine();
        N = Integer.parseInt(n);

        arr = new int[N];
        String[] sa = bf.readLine().split(" ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(sa[i]);
        }

        two(0, 0, 0, 0);
        System.out.println(max);

    }

    public static void two(int left, int right, int count, int type){
        if(left > right || right >= N){
            return;
        }

        // 만약에 right 지점의 과일이 아직 0개라면
        if(fruit[arr[right]] == 0){
            // 종류 + 1
            type++;
        }
        // 총 개수 + 1
        count++;
        // 해당 과일 + 1
        fruit[arr[right]]++;

        // 만약에 과일 종류가 3개 이상이라면
        while(type >= 3){
            // 왼쪽 포인터에 있는 과일, 개수, 종류 제거
            fruit[arr[left]]--;
            if(fruit[arr[left]] == 0){
                type--;
            }
            count--;
            left++;
        }

        // 최대값 비교
        max = Math.max(max, count);

        two(left, right + 1, count, type);
    }
}