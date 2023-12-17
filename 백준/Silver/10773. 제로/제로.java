
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int K = Integer.parseInt(s);

        Stack<Integer> stack = new Stack();

        for(int k=0; k<K; k++){
            s = bf.readLine();
            int N = Integer.parseInt(s);

            if (N != 0){
                stack.push(N);
            }else{
                if (stack.size() != 0){
                    stack.pop();
                }
            }
        }
        
        int result = 0;
        while (stack.size() != 0){
            result += stack.pop();
        }

        System.out.println(result);
    }
}
