import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static long q = 0l;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(bf.readLine());

        binarySearch(n);

        System.out.println(q);
    }

    public static void binarySearch(long n){
        long l = 0l;
        long r = n;

        while(l <= r){
            long mid = (r + l) / 2;
            if(Math.pow(mid, 2) >= n){
                r = mid - 1;
                q = mid;
            }else{
                l = mid + 1;
            }
        }
    }
}