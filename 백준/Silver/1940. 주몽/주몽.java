import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        int N = Integer.parseInt(s);
        s = bf.readLine();
        int M = Integer.parseInt(s);
        String[] s1 = bf.readLine().split(" ");
        int[] arr = new int[s1.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(s1[i]);
        }

        Arrays.sort(arr);

        int start = 0;
        int end = arr.length - 1;
        int count = 0;

        while(start < end){
            if(arr[start] + arr[end] > M){
                end--;
            }else if(arr[start] + arr[end] < M){
                start++;
            }else{
                count++;
                start++;
                end--;
            }
        }

        System.out.println(count);
    }
}