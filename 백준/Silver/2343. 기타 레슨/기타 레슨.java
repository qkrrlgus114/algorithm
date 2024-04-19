import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;

    /*
    * N : 강의 수, M : 블루레이 수
    * M개의 블루레이는 전부 같은 크기여야 한다.
    * 블루레이의 크기를 최소로 만들자.
    * 블루레이 하나에는 최소 하나의 강의가 담겨야 하므로, 시작은 최대 길이
    * */

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);
        sa = bf.readLine().split(" ");
        arr = new int[N];

        int left = 0, right = 0;

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(sa[i]);
            left = Math.max(left, arr[i]);
            right += arr[i];
        }

        while(left <= right){
            int mid = (left + right) / 2;
            int sum = 0;
            int count = 0;

            for(int i=0; i<N; i++){
                if(sum + arr[i] > mid){
                    count++;
                    sum = 0;
                }
                sum += arr[i];
            }
            if(sum != 0) count++;
            if(count > M){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        System.out.println(left);

    }
}