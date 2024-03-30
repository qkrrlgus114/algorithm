import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
    * 앞 사람이 최대한 빨리 끝나는 게 좋음.
    * 결국 정렬을 해서 계산하면 됨
    * */

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        int N = Integer.parseInt(s);

        String[] sa = bf.readLine().split(" ");
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(sa[i]);
        }

        Arrays.sort(arr);

        int sum = 0;
        int result = 0;
        for(int i=0; i<N; i++){
            sum += arr[i];
            result += sum;
        }

        System.out.println(result);
    }
}



