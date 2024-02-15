import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input = bf.readLine();
        int N = Integer.parseInt(input);
        Stack<Integer> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[N];
        int[] result = new int[N];

        String[] inputs = bf.readLine().split(" ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(inputs[i]);
        }

        for(int i=0; i<N; i++){
            while(!s.isEmpty() && arr[s.peek()] < arr[i]){
                result[s.pop()] = arr[i];
            }

            s.push(i);
        }

        while(!s.isEmpty()){
            result[s.pop()] = -1;
        }

        for(int num : result){
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString());
    }
}