import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int max = 0;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        // 접시의 수
        int N = Integer.parseInt(sa[0]);
        // 가짓수
        int d = Integer.parseInt(sa[1]);
        // 먹을 접시의 수(연속)
        int k = Integer.parseInt(sa[2]);
        // 쿠폰 번호
        int c = Integer.parseInt(sa[3]);
        // 최대 고른 초밥
        max = 0;
        arr = new int[3001];
        int[] sushi = new int[N];
        for (int i = 0; i < N; i++) {
            String s = bf.readLine();
            sushi[i] = Integer.parseInt(s);
        }

        // 현재 초밥의 가짓수
        int count = 0;
        // 초기 초밥 정함(윈도우)
        for (int i = 0; i < k; i++) {
            if (arr[sushi[i]] == 0) {
                arr[sushi[i]]++;
                count++;
            } else arr[sushi[i]]++;
        }
        checkCoupon(c, count);

        for (int i = 0; i < N; i++) {
            // 맨 앞의 초밥 제거
            if (arr[sushi[i % N]] != 0) {
                arr[sushi[i % N]]--;
                if (arr[sushi[i % N]] == 0) count--;
            }
            // 새로운 초밥 추가
            int nextSushi = sushi[(i + k) % N]; // 원형 벨트를 고려하여 인덱스 계산
            if (arr[nextSushi] == 0) {
                count++;
            }
            arr[nextSushi]++;
            checkCoupon(c, count);
        }

        System.out.println(max);

    }

    public static void checkCoupon(int coupon, int count){
        if(arr[coupon] == 0){
            max = Math.max(max, count + 1);
        }else max = Math.max(max, count);
    }
}