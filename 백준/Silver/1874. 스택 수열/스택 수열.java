import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

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

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        // 1부터 N까지 판단하는 값
        int cur = 1;
        boolean check = false;

        for(int i=0; i<N; i++){
            if(arr[i] >= cur){
                while(true){
                    if(arr[i] > cur){
                        stack.push(cur++);
                        sb.append("+\n");
                    }else{
                        sb.append("+\n");
                        cur++;
                        sb.append("-\n");
                        break;
                    }
                }
            }else{
                if(stack.peek() == arr[i]){
                    stack.pop();
                    sb.append("-\n");
                }else{
                    System.out.println("NO");
                    check = true;
                    break;
                }
            }
        }

        if(!check){
            System.out.println(sb.toString());
        }
    }
}