import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static Long[] house;
    static int N;
    static int C;
    static Long result = Long.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");

        N = Integer.parseInt(sa[0]);
        C = Integer.parseInt(sa[1]);

        house = new Long[N];
        for(int i=0; i<N; i++){
            String s = bf.readLine();
            house[i] = Long.parseLong(s);
        }

        Arrays.sort(house);

        binarySearch(1L, house[N-1]);
        System.out.println(result);
    }

    public static void binarySearch(Long low, Long high){
        if(low > high) return;

        Long mid = (low + high) / 2;

        int count = 1;
        int house_index = 0;
        for(int i=1; i<house.length; i++){
            if(house[i] - house[house_index] >= mid){
                count++;
                house_index = i;
            }
        }

        // 설치한 공유기의 개수가 적으면
        if(count < C){
            binarySearch(low, mid-1);
        }else{
            if(result < mid) result = mid;
            binarySearch(mid+1, high);
        }
    }



}