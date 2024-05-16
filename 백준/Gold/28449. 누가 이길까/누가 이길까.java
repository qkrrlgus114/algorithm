import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);

        int[] a = new int[N];
        int[] b = new int[M];

        sa = bf.readLine().split(" ");
        for(int i=0; i<N; i++){
            a[i] = Integer.parseInt(sa[i]);
        }

        sa = bf.readLine().split(" ");
        for(int i=0; i<M; i++){
            b[i] = Integer.parseInt(sa[i]);
        }

        Arrays.sort(a);
        Arrays.sort(b);

        long aWin = 0;
        long bWin = 0;
        long draw = 0;

        for(int i = 0; i < N; i++){
            int start = lowerBound(b, a[i]);
            int end = upperBound(b, a[i]);

            aWin += start;
            bWin += b.length - end;
            draw += end - start;
        }

        System.out.println(aWin + " " + bWin + " " + draw);
    }

    public static int lowerBound(int[] b, int target){
        int l = 0;
        int r = b.length;

        while(l < r){
            int mid = (l + r) / 2;

            if(b[mid] < target){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return l;
    }

    public static int upperBound(int[] b, int target){
        int l = 0;
        int r = b.length;

        while(l < r){
            int mid = (l + r) / 2;
            if(b[mid] <= target){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return l;
    }


}

