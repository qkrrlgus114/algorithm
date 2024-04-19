import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] country;
    static int money;
    static int maxReslut = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        N = Integer.parseInt(s);
        country = new int[N];
        String[] sa = bf.readLine().split(" ");
        for(int i=0; i<N; i++){
            country[i] = Integer.parseInt(sa[i]);
        }
        Arrays.sort(country);

        s = bf.readLine();
        money = Integer.parseInt(s);
        int sum = 0;
        int max = 0;
        for(int i : country){
            sum += i;
            max = Math.max(max, i);
        }
        if(sum <= money){
            System.out.println(max);
        }else{
            binarySearch(0, max);
            System.out.println(maxReslut);
        }
    }

    public static void binarySearch(int left, int right){
        if(left > right) return;

        int mid = (left + right) / 2;
        int sum = 0;
        for(int num : country){
            if(mid > num) sum += num;
            else sum += mid;
        }

        // 만약에 예산이 초과하면
        if(sum > money){
            binarySearch(left, mid - 1);
        }else{
            maxReslut = Math.max(maxReslut, mid);
            binarySearch(mid + 1, right);
        }
    }
}