import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");

        int N = Integer.parseInt(sa[0]);
        int L = Integer.parseInt(sa[1]);

        int[] arr = new int[N];
        sa = bf.readLine().split(" ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(sa[i]);
        }

        Arrays.sort(arr);

        int temp = arr[0];
        int count = 0;
        for(int i=1; i<N; i++){
            if(arr[i] - temp < L) continue;
            else{
                count++;
                temp = arr[i];
            }
        }

        System.out.println(count + 1);


    }


}