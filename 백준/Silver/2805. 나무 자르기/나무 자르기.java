import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);

        trees = new int[N];
        int max = 0;
        sa = bf.readLine().split(" ");
        for(int i=0; i<N; i++){
            trees[i] = Integer.parseInt(sa[i]);
            max = Math.max(trees[i], max);
        }

        long result = binarySearch(0, max);

        System.out.println(result);
    }

    public static long binarySearch(int l, int r){
        long result = 0;

        while(l <= r){
            int mid = (l + r) / 2;

            long sum = 0;
            for(Integer tree : trees){
                sum += tree - mid <= 0 ? 0 : tree -mid;
            }

            if(M <= sum){
                l = mid + 1;
                result = Math.max(result, mid);
            }else{
                r = mid - 1;
            }
        }

        return result;
    }
}
