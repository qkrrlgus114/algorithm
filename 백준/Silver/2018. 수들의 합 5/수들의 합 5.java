import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        int N = Integer.parseInt(s);

        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = i + 1;
        }

        int start = 0;
        int end = 0;
        int count = 1;

        while(end != N-1){
            int sum = 0;
            for(int i=start; i<=end; i++){
                sum += arr[i];
            }

            if(sum > N){
                sum -= arr[start];
                start++;
            }else if(sum < N){
                end++;
                sum += arr[end];
            }else{
                end++;
                sum += arr[end];
                count++;
            }
        }

        System.out.println(count);

    }
}