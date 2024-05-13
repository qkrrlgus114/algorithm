import javax.security.auth.login.AccountNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


public class Main {

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int N = Integer.parseInt(s);

        String[] sa = bf.readLine().split(" ");
        int A = Integer.parseInt(sa[0]);
        int B = Integer.parseInt(sa[1]);

        arr = new int[N][2];
        for(int i=0; i<N; i++){
            sa = bf.readLine().split(" ");
            arr[i][0] = Integer.parseInt(sa[0]);
            arr[i][1] = Integer.parseInt(sa[1]);
        }

        Arrays.sort(arr, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        // 정답 개수
        int answer = 0;

        for(int i=0; i<N; i++){
            int[] target = arr[i];
            if(search(0, N-1, target[0], target[1] + B)
            && search(0, N-1, target[0] + A, target[1])
            && search(0, N-1, target[0] + A, target[1] + B)){
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static boolean search(int start, int end, int y, int x){
        if(start > end) return false;

        int mid = (start + end) / 2;
        int[] target = arr[mid];

        if(target[0] == y && target[1] == x) return true;
        else if(target[1] > x){
            return search(start, mid - 1, y, x);
        }else if(target[1] < x){
            return search(mid + 1, end, y, x);
        }else if(target[0] > y){
            return search(start, mid - 1, y, x);
        }else if(target[0] < y){
            return search(mid + 1, end, y, x);
        }

        return false;
    }
}

