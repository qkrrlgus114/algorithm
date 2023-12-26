import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        int N = Integer.parseInt(s);

        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            s = bf.readLine();
            arr[i] = Integer.parseInt(s);
        }

        for(int i=0; i<N-1; i++){
            for(int j=0; j<N-i-1; j++){
                if(arr[j] > arr[j+1]){
                    bubbleSort(arr, j, j+1);
                }
            }
        }

        for(int i : arr){
            System.out.println(i);
        }
    }

    public static void bubbleSort(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}