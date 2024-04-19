import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] targetArr;
    static int[] searchArr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int N = Integer.parseInt(s);
        String[] sa = bf.readLine().split(" ");
        targetArr = new int[N];
        for(int i=0; i<N; i++){
            targetArr[i] = Integer.parseInt(sa[i]);
        }
        s = bf.readLine();
        int M = Integer.parseInt(s);
        sa = bf.readLine().split(" ");
        searchArr = new int[M];
        for(int i=0; i<M; i++){
            searchArr[i] = Integer.parseInt(sa[i]);
        }


        // 이분 탐색 진행
        Arrays.sort(targetArr);

        List<Integer> result = new ArrayList<>();

        for(int i=0; i<M; i++){
            boolean value = binarySearch(0, N-1, searchArr[i]);
            if(value) result.add(1);
            else result.add(0);
        }

        for(Integer i : result){
            System.out.println(i);
        }

    }

    public static boolean binarySearch(int start, int end, int target){
        if(start > end){
            return false;
        }

        int mid = (start + end) / 2;
        int value = targetArr[mid];

        if(target == value) return true;
        else if(target > value){
            return binarySearch(mid + 1, end, target);
        }else{
            return binarySearch(start, mid - 1, target);
        }
    }
}