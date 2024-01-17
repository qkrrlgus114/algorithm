import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int M;
    static int shop_n;
    static int[][] shop;
    static int[] dong = new int[2];
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);

        String s = bf.readLine();
        shop_n = Integer.parseInt(s);
        shop = new int[shop_n][2];

        // 상점 입력
        for (int i = 0; i < shop_n; i++) {
            sa = bf.readLine().split(" ");
            shop[i][0] = Integer.parseInt(sa[0]);
            shop[i][1] = Integer.parseInt(sa[1]);
        }

        // 동근이 입력
        sa = bf.readLine().split(" ");
        dong[0] = Integer.parseInt(sa[0]);
        dong[1] = Integer.parseInt(sa[1]);

        // 상점 하나씩 확인
        for (int i = 0; i < shop_n; i++) {
            // 동근이의 위치에 따라서
            if (dong[0] == 1) {
                check(1, i);
            } else if (dong[0] == 2) {
                check(2, i);
            } else if (dong[0] == 3) {
                check(3, i);
            } else if (dong[0] == 4) {
                check(4, i);
            }
        }
        System.out.println(result);
    }

    public static void check(int dong_dir, int index) {
        // 현재 상점의 위치
        int temp = shop[index][0];
        // 동근이가 북이면 남쪽의 위치를 확인
        if(dong_dir == 1){
            if(temp == 1) result += Math.abs(dong[1] - shop[index][1]);
            else if(temp == 2){
                result += Math.min(dong[1] + M + shop[index][1], (N - dong[1]) + M + (N - shop[index][1]));
            }else if(temp == 3){
                result += dong[1] + shop[index][1];
            }else{
                result += N - dong[1] + shop[index][1];
            }
        }else if(dong_dir == 2){
            if(temp == 2) result += Math.abs(dong[1] - shop[index][1]);
            else if(temp == 1){
                result += Math.min(dong[1] + M + shop[index][1], (N - dong[1]) + M + (N - shop[index][1]));
            }else if(temp == 3){
                result += dong[1] + M - shop[index][1];
            }else{
                result += N - dong[1] + M - shop[index][1];
            }
        }else if(dong_dir == 3){
            if(temp == 3) result += Math.abs(dong[1] - shop[index][1]);
            else if(temp == 1){
                result += shop[index][1] + dong[1];
            }else if(temp == 2){
                result += M - dong[1] + shop[index][1];
            }else{
                result += Math.min(dong[1] + N + shop[index][1], (M - dong[1]) + N + (M - shop[index][1]));
            }
        }else{
            if(temp == 4) result += Math.abs(dong[1] - shop[index][1]);
            else if(temp == 1){
                result += N - shop[index][1] + dong[1];
            }else if(temp == 2){
                result += (M - dong[1])+ (N - shop[index][1]);
            }else{
                result += Math.min(dong[1] + N + shop[index][1], (M - dong[1]) + N + (M - shop[index][1]));
            }
        }
    }
}