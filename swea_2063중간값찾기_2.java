import java.util.Arrays;
import java.util.Scanner;
 
public class swea_2063중간값찾기_2 {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        for (int tc = 1; tc <= 10; tc++) {
            int D = sc.nextInt();
            int[] cnt = new int[101];
            int high = 0;
            int low = 100;
 
            for (int i = 1; i <= 100; i++) {
                int num = sc.nextInt();
                cnt[num]++;
                if (num > high)
                    high = num;
                if (num < low)
                    low = num;
            }
 
            while (D > 0) {
                cnt[high]--;
                cnt[high - 1]++;
                cnt[low]--;
                cnt[low + 1]++;
 
                while (cnt[high] == 0)
                    high--;
                while (cnt[low] == 0)
                    low++;
                D--;
 
            }
            System.out.println("#" + tc + " " + (high - low));
        }
 
    }
 
}