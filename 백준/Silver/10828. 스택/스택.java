import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(bf.readLine());
        for(int i=0; i<N; i++){
            String[] sa = bf.readLine().split(" ");
            String command = sa[0];
            if(command.equals("push")){
                stack.add(Integer.parseInt(sa[1]));
            }else if(command.equals("pop")){
                if(stack.isEmpty()) sb.append(-1).append("\n");
                else sb.append(stack.pop()).append("\n");
            }else if(command.equals("size")){
                sb.append(stack.size()).append("\n");
            }else if(command.equals("empty")){
                if(stack.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }else if(command.equals("top")){
                if(stack.isEmpty()) sb.append(-1).append("\n");
                else sb.append(stack.peek()).append("\n");
            }
        }

        System.out.println(sb);
    }
}
